package com.ziadsyahrul.submissionjetpackpro.data.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.ziadsyahrul.submissionjetpackpro.data.local.entity.MovieEntity
import com.ziadsyahrul.submissionjetpackpro.data.local.entity.TvShowEntity
import com.ziadsyahrul.submissionjetpackpro.data.local.room.CatalogueDao

class LocalDataSource(private val mCatalogueDao: CatalogueDao) {
    companion object{
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(catalogueDao: CatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(catalogueDao)
    }

    fun getAllMovie(): DataSource.Factory<Int, MovieEntity> = mCatalogueDao.getMovie()

    fun getMovieById(movieId: Int): LiveData<MovieEntity> = mCatalogueDao.getMoviesById(movieId)

    fun getFavMovie(): DataSource.Factory<Int, MovieEntity> = mCatalogueDao.getMovFavorite()

    fun getAllTv(): DataSource.Factory<Int, TvShowEntity> = mCatalogueDao.getTvShow()

    fun getTvById(tvShowId: Int): LiveData<TvShowEntity> = mCatalogueDao.getTvById(tvShowId)

    fun getFavTv(): DataSource.Factory<Int, TvShowEntity> = mCatalogueDao.getTvFavorite()

    fun insertMovie(movie: List<MovieEntity>) = mCatalogueDao.insertMovie(movie)

    fun setFavMov(movie: MovieEntity){
        movie.isFav = !movie.isFav
        mCatalogueDao.updateMovie(movie)
    }

    fun updateMovies(movie: MovieEntity){
        movie.isFav = !movie.isFav
        mCatalogueDao.updateMovie(movie)
    }

    fun insertTvShow(tvShow: List<TvShowEntity>) = mCatalogueDao.insertTv(tvShow)

    fun setFavTv(tvShow: TvShowEntity){
        tvShow.isFav = !tvShow.isFav
        mCatalogueDao.updateTv(tvShow)
    }

    fun updateTv(tvShow: TvShowEntity){
        tvShow.isFav = !tvShow.isFav
        mCatalogueDao.updateTv(tvShow)
    }
}