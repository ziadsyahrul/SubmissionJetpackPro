package com.ziadsyahrul.submissionjetpackpro.ui.movie

import androidx.lifecycle.ViewModel
import com.ziadsyahrul.submissionjetpackpro.data.FilmRepository

class MovieViewModel(private val filmRepository: FilmRepository): ViewModel() {
    fun getMoviess() = filmRepository.getMovie()
}