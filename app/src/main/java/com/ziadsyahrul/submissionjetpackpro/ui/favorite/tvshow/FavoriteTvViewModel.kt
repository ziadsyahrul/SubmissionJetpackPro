package com.ziadsyahrul.submissionjetpackpro.ui.favorite.tvshow

import androidx.lifecycle.ViewModel
import com.ziadsyahrul.submissionjetpackpro.data.FilmRepository

class FavoriteTvViewModel(private val filmRepository: FilmRepository): ViewModel() {

    fun getFavTvShows() = filmRepository.getTvFavorite()

}