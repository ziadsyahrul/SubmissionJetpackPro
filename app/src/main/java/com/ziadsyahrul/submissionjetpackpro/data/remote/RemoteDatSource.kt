package com.ziadsyahrul.submissionjetpackpro.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ziadsyahrul.submissionjetpackpro.data.remote.response.mov.MovieResponse
import com.ziadsyahrul.submissionjetpackpro.data.remote.response.mov.ResultsMovie
import com.ziadsyahrul.submissionjetpackpro.data.remote.response.tv.ResultsTv
import com.ziadsyahrul.submissionjetpackpro.data.remote.response.tv.TvShowResponse
import com.ziadsyahrul.submissionjetpackpro.network.ApiConfig
import com.ziadsyahrul.submissionjetpackpro.util.Constant
import com.ziadsyahrul.submissionjetpackpro.util.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDatSource {
    companion object{

        @Volatile
        private var instance: RemoteDatSource? = null

        fun getInstance(): RemoteDatSource =
                instance ?: synchronized(this){
                    instance ?: RemoteDatSource()
                }
    }


    fun getMovie(): LiveData<ApiResponse<List<ResultsMovie>>>{
        EspressoIdlingResource.increment()
        val resultMov = MutableLiveData<ApiResponse<List<ResultsMovie>>>()
        val client = ApiConfig.getApiService().getMovie(Constant.API_KEY)
        client.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                resultMov.value = ApiResponse.success(response.body()?.results as List<ResultsMovie>)
                Log.d("MOVIE", response.body()?.results.toString())
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.d("RemoteData", "onFailure: ${t.message}")
                EspressoIdlingResource.decrement()
            }

        })
        return resultMov
    }


    fun getTvShow(): LiveData<ApiResponse<List<ResultsTv>>>{
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<ResultsTv>>>()
        val client = ApiConfig.getApiService().getTvShow(Constant.API_KEY)
        client.enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(
                call: Call<TvShowResponse>,
                response: Response<TvShowResponse>
            ) {
                resultTvShow.value = ApiResponse.success(response.body()?.results as List<ResultsTv>)
                Log.d("TVSHOW", response.body()?.results.toString())
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.d("RemoteData", "onFailure: ${t.message}")
                EspressoIdlingResource.decrement()
            }

        })
        return resultTvShow
    }

}