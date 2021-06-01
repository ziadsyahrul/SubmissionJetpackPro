package com.ziadsyahrul.submissionjetpackpro.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ziadsyahrul.submissionjetpackpro.data.FilmRepository
import com.ziadsyahrul.submissionjetpackpro.data.local.DetailModel
import com.ziadsyahrul.submissionjetpackpro.data.local.MovieModel
import com.ziadsyahrul.submissionjetpackpro.util.DataDummy

class DetailViewModel(private val filmRepository: FilmRepository): ViewModel() {

    fun getMovDetail(movieId: Int): LiveData<DetailModel> =
        filmRepository.getMovDetail(movieId)

    fun getTvDetail(tvId: Int): LiveData<DetailModel> =
        filmRepository.getTvShowDetail(tvId)

}