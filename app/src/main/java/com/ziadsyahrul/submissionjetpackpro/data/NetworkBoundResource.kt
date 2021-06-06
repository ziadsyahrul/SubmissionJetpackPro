package com.ziadsyahrul.submissionjetpackpro.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.ziadsyahrul.submissionjetpackpro.data.remote.ApiResponse
import com.ziadsyahrul.submissionjetpackpro.data.remote.StatusResponse
import com.ziadsyahrul.submissionjetpackpro.util.AppExecutors
import com.ziadsyahrul.submissionjetpackpro.vo.Resource

abstract class NetworkBoundResource<ResultType, RequestType>(private val mExecutors: AppExecutors) {

    private val result = MediatorLiveData<Resource<ResultType>>()

    init {
        result.value = Resource.loading(null)


        val dbSource = loadFromDb()

        result.addSource(dbSource) { data ->
            result.removeSource(dbSource)
            if (shouldFetch(data)) {
                fetchFromNetwork(dbSource)
            }else{
                result.addSource(dbSource) { newData ->
                    result.value = Resource.success(newData)
                }
            }
        }
    }

    protected fun onFetchFailed() {}

    protected abstract fun loadFromDb(): LiveData<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract fun createCall(): LiveData<ApiResponse<RequestType>>

    protected abstract fun saveCallResult(data: RequestType)

    private fun fetchFromNetwork(dbSource: LiveData<ResultType>) {
        val apiResponse = createCall()

        result.addSource(dbSource) { newData ->
            result.value = Resource.loading(newData)
        }

        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)
            result.removeSource(dbSource)
            when(response.status) {
                StatusResponse.SUCCESS ->
                    mExecutors.diskIO().execute {
                        saveCallResult(response.body)
                        mExecutors.mainThread().execute{
                            result.addSource(loadFromDb()) { newData ->
                                result.value = Resource.success(newData)
                            }
                        }
                    }

                StatusResponse.EMPTY -> mExecutors.mainThread().execute{
                    result.addSource(loadFromDb()) { newData ->
                        result.value = Resource.success(newData)
                    }
                }

                StatusResponse.ERROR ->{
                    onFetchFailed()
                    result.addSource(dbSource) { newData ->
                        result.value = Resource.error(response.message, newData)
                    }
                }
            }
        }
    }

    fun asLiveData(): LiveData<Resource<ResultType>> = result

}