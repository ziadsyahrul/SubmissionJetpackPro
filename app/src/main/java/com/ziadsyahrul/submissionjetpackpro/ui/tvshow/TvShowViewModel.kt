package com.ziadsyahrul.submissionjetpackpro.ui.tvshow

import androidx.lifecycle.ViewModel
import com.ziadsyahrul.submissionjetpackpro.data.FilmRepository
import com.ziadsyahrul.submissionjetpackpro.util.DataDummy

class TvShowViewModel(private val filmRepository: FilmRepository): ViewModel() {
    fun getTvShow() = filmRepository.getTvShow()
}