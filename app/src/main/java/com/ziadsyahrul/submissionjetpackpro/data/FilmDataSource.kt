package com.ziadsyahrul.submissionjetpackpro.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.ziadsyahrul.submissionjetpackpro.data.local.entity.MovieEntity
import com.ziadsyahrul.submissionjetpackpro.data.local.entity.TvShowEntity
import com.ziadsyahrul.submissionjetpackpro.vo.Resource

interface FilmDataSource {

    fun getMovie(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getMovDetail(movId: Int): LiveData<MovieEntity>

    fun getMovFavorite(): LiveData<PagedList<MovieEntity>>

    fun setMovFavorite(movie: MovieEntity)

    fun getTvShow(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getTvShowDetail(tvId: Int): LiveData<TvShowEntity>

    fun getTvFavorite(): LiveData<PagedList<TvShowEntity>>

    fun setTvFavorite(tvShow: TvShowEntity)

}