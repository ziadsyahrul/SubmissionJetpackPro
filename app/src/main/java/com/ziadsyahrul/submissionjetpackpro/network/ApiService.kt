package com.ziadsyahrul.submissionjetpackpro.network

import com.ziadsyahrul.submissionjetpackpro.data.remote.response.mov.DetailMovResponse
import com.ziadsyahrul.submissionjetpackpro.data.remote.response.mov.MovieResponse
import com.ziadsyahrul.submissionjetpackpro.data.remote.response.tv.TvShowDetailResponse
import com.ziadsyahrul.submissionjetpackpro.data.remote.response.tv.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("discover/movie")
    fun getMovie(@Query("api_key") apiKey: String) : Call<MovieResponse>

    @GET("movie/{id}")
    fun getMovDetail(@Path("id") movId: String,
                     @Query("api_key") apiKey: String) : Call<DetailMovResponse>

    @GET("discover/tv")
    fun getTvShow(@Query("api_key") apiKey: String) : Call<TvShowResponse>

    @GET("tv/{id}")
    fun getTvDetail(@Path("id") tvId: String,
                    @Query("api_key") apiKey: String) : Call<TvShowDetailResponse>

}