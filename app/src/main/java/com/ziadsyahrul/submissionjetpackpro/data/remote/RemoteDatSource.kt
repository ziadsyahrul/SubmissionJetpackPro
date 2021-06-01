package com.ziadsyahrul.submissionjetpackpro.data.remote

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.ziadsyahrul.submissionjetpackpro.data.remote.response.mov.DetailMovResponse
import com.ziadsyahrul.submissionjetpackpro.data.remote.response.mov.MovieResponse
import com.ziadsyahrul.submissionjetpackpro.data.remote.response.mov.ResultsItem
import com.ziadsyahrul.submissionjetpackpro.data.remote.response.tv.TvShowDetailResponse
import com.ziadsyahrul.submissionjetpackpro.data.remote.response.tv.TvShowResponse
import com.ziadsyahrul.submissionjetpackpro.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDatSource {
    companion object{

        const val API_KEY = "07f21ca8526a5988e3a4202e8f3cff99"

        @Volatile
        private var instance: RemoteDatSource? = null

        fun getInstance(): RemoteDatSource =
                instance ?: synchronized(this){
                    instance ?: RemoteDatSource()
                }
    }


    fun getMovie(callBack: LoadMovieCallBack){
        val client = ApiConfig.getApiService().getMovie(API_KEY)
        client.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                callBack.onAllMovieReceived(response.body()?.results)

            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.d("RemoteData", "onFailure: ${t.message}")
            }

        })
    }

    fun getDetailMov(callBack: LoadDetailMovCallBack, movieId: String){
        val client = ApiConfig.getApiService().getMovDetail(movieId, API_KEY)
        client.enqueue(object : Callback<DetailMovResponse> {
            override fun onResponse(
                call: Call<DetailMovResponse>,
                response: Response<DetailMovResponse>
            ) {
                callBack.onDetailMovReceived(response.body())
            }

            override fun onFailure(call: Call<DetailMovResponse>, t: Throwable) {
                Log.d("RemoteData", "onFailure: ${t.message}")
            }

        })
    }

    fun getTvShow(callBack: LoadTvShowCallBack){
        val client = ApiConfig.getApiService().getTvShow(API_KEY)
        client.enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(
                call: Call<TvShowResponse>,
                response: Response<TvShowResponse>
            ) {
                callBack.onAllTvShowReceived(response.body()?.results)
                Log.d("TVSHOW", response.body()?.results.toString())
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.d("RemoteData", "onFailure: ${t.message}")
            }

        })
    }

    fun getTvshowDetail(callBack: LoadTvShowDetailCallBack, tvShowId: String){
        val client = ApiConfig.getApiService().getTvDetail(tvShowId, API_KEY)
        client.enqueue(object : Callback<TvShowDetailResponse> {
            override fun onResponse(call: Call<TvShowDetailResponse>, response: Response<TvShowDetailResponse>) {
                callBack.onDetailTvShowReceived(response.body())

            }

            override fun onFailure(call: Call<TvShowDetailResponse>, t: Throwable) {
                Log.d("RemoteData", "onFailure: ${t.message}")
            }

        })
    }


    interface LoadTvShowDetailCallBack {
        fun onDetailTvShowReceived(tvShowResponse: TvShowDetailResponse?)
    }

    interface LoadTvShowCallBack {
        fun onAllTvShowReceived(tvShowResponse: List<com.ziadsyahrul.submissionjetpackpro.data.remote.response.tv.ResultsItem>?)
    }

    interface LoadDetailMovCallBack {
        fun onDetailMovReceived(movieResponse: DetailMovResponse?)
    }

    interface LoadMovieCallBack {
        fun onAllMovieReceived(movieResponse: List<ResultsItem>?)
    }
}