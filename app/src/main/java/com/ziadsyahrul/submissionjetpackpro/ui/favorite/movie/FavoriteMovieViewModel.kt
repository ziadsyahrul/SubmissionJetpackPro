package com.ziadsyahrul.submissionjetpackpro.ui.favorite.movie

import androidx.lifecycle.ViewModel
import com.ziadsyahrul.submissionjetpackpro.data.FilmRepository

class FavoriteMovieViewModel(private val filmRepository: FilmRepository): ViewModel() {
    fun getFavoriteMovie() = filmRepository.getMovFavorite()

}