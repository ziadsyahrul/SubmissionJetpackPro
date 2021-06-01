package com.ziadsyahrul.submissionjetpackpro.data

import androidx.lifecycle.LiveData
import com.ziadsyahrul.submissionjetpackpro.data.local.DetailModel
import com.ziadsyahrul.submissionjetpackpro.data.local.MovieModel
import com.ziadsyahrul.submissionjetpackpro.data.local.TvShowModel

interface FilmDataSource {

    fun getMovie(): LiveData<List<MovieModel>>
    fun getMovDetail(movId: String): LiveData<DetailModel>
    fun getTvShow(): LiveData<List<TvShowModel>>
    fun getTvShowDetail(tvId: String): LiveData<DetailModel>

}