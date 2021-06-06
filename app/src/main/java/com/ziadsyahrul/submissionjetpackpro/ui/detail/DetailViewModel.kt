package com.ziadsyahrul.submissionjetpackpro.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ziadsyahrul.submissionjetpackpro.data.FilmRepository
import com.ziadsyahrul.submissionjetpackpro.data.local.entity.MovieEntity
import com.ziadsyahrul.submissionjetpackpro.data.local.entity.TvShowEntity
import com.ziadsyahrul.submissionjetpackpro.vo.Resource

class DetailViewModel(private val filmRepository: FilmRepository): ViewModel() {

    fun getMovDetail(movieId: Int): LiveData<MovieEntity> =
        filmRepository.getMovDetail(movieId)

    fun getTvDetail(tvId: Int): LiveData<TvShowEntity> =
        filmRepository.getTvShowDetail(tvId)

    fun setFavMovie(movie: MovieEntity){
        filmRepository.setMovFavorite(movie)
    }

    fun setFavTv(tvShow: TvShowEntity){
        filmRepository.setTvFavorite(tvShow)
    }
}