package com.ziadsyahrul.submissionjetpackpro.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ziadsyahrul.submissionjetpackpro.data.remote.response.mov.DetailMovResponse
import com.ziadsyahrul.submissionjetpackpro.data.remote.response.mov.MovieResponse
import com.ziadsyahrul.submissionjetpackpro.data.remote.response.mov.ResultsMovie
import com.ziadsyahrul.submissionjetpackpro.data.remote.response.tv.ResultsTv
import com.ziadsyahrul.submissionjetpackpro.data.remote.response.tv.TvShowDetailResponse
import com.ziadsyahrul.submissionjetpackpro.data.remote.response.tv.TvShowResponse
import com.ziadsyahrul.submissionjetpackpro.network.ApiConfig
import com.ziadsyahrul.submissionjetpackpro.util.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDatSource {
    companion object{

        private val API_KEY = "07f21ca8526a5988e3a4202e8f3cff99"

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
        val client = ApiConfig.getApiService().getMovie(API_KEY)
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

    fun getDetailMov(movieId: Int): LiveData<ApiResponse<DetailMovResponse>>{
        EspressoIdlingResource.increment()
        val resultDetailMov = MutableLiveData<ApiResponse<DetailMovResponse>>()
        val client = ApiConfig.getApiService().getMovDetail(movieId, API_KEY)
        client.enqueue(object : Callback<DetailMovResponse> {
            override fun onResponse(
                call: Call<DetailMovResponse>,
                response: Response<DetailMovResponse>
            ) {
                resultDetailMov.value = ApiResponse.success(response.body() as DetailMovResponse)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<DetailMovResponse>, t: Throwable) {
                Log.d("RemoteData", "onFailure: ${t.message}")
                EspressoIdlingResource.decrement()
            }

        })
        return resultDetailMov
    }

    fun getTvShow(): LiveData<ApiResponse<List<ResultsTv>>>{
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<ResultsTv>>>()
        val client = ApiConfig.getApiService().getTvShow(API_KEY)
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

    fun getTvshowDetail(tvShowId: Int): LiveData<ApiResponse<TvShowDetailResponse>>{
        EspressoIdlingResource.increment()
        val resultTvDetail = MutableLiveData<ApiResponse<TvShowDetailResponse>>()
        val client = ApiConfig.getApiService().getTvDetail(tvShowId, API_KEY)
        client.enqueue(object : Callback<TvShowDetailResponse> {
            override fun onResponse(call: Call<TvShowDetailResponse>, response: Response<TvShowDetailResponse>) {
                resultTvDetail.value = ApiResponse.success(response.body() as TvShowDetailResponse)
                EspressoIdlingResource.decrement()

            }

            override fun onFailure(call: Call<TvShowDetailResponse>, t: Throwable) {
                Log.d("RemoteData", "onFailure: ${t.message}")
                EspressoIdlingResource.decrement()
            }

        })
        return resultTvDetail
    }


//    interface LoadTvShowDetailCallBack {
//        fun onDetailTvShowReceived(tvShowResponse: TvShowDetailResponse?)
//    }
//
//    interface LoadTvShowCallBack {
//        fun onAllTvShowReceived(tvShowResponse: List<com.ziadsyahrul.submissionjetpackpro.data.remote.response.tv.ResultsTv>?)
//    }
//
//    interface LoadDetailMovCallBack {
//        fun onDetailMovReceived(movieResponse: DetailMovResponse?)
//    }
//
//    interface LoadMovieCallBack {
//        fun onAllMovieReceived(movieResponse: List<ResultsMovie>?)
//    }
}