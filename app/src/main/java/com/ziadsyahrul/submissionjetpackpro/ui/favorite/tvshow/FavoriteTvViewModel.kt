package com.ziadsyahrul.submissionjetpackpro.ui.favorite.tvshow

import androidx.lifecycle.ViewModel
import com.ziadsyahrul.submissionjetpackpro.data.FilmRepository
import com.ziadsyahrul.submissionjetpackpro.data.local.entity.TvShowEntity

class FavoriteTvViewModel(private val filmRepository: FilmRepository): ViewModel() {

    fun getFavTvShows() = filmRepository.getTvFavorite()

}