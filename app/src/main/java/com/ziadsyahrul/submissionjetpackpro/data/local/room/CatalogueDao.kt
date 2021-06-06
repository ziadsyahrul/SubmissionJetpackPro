package com.ziadsyahrul.submissionjetpackpro.data.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.ziadsyahrul.submissionjetpackpro.data.local.entity.MovieEntity
import com.ziadsyahrul.submissionjetpackpro.data.local.entity.TvShowEntity

@Dao
interface CatalogueDao {
    @Query("SELECT * FROM movieentity")
    fun getMovie(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieentity WHERE id = :movieId")
    fun getMoviesById(movieId: Int): LiveData<MovieEntity>

    @Query("SELECT * FROM movieentity WHERE isFav = 1")
    fun getMovFavorite(): DataSource.Factory<Int, MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Query("SELECT * FROM tvshowentity")
    fun getTvShow(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM tvshowentity WHERE id = :tvShowId")
    fun getTvById(tvShowId: Int): LiveData<TvShowEntity>

    @Query("SELECT * FROM tvshowentity WHERE isFav = 1")
    fun getTvFavorite(): DataSource.Factory<Int, TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTv(tvShow: List<TvShowEntity>)

    @Update
    fun updateTv(tvShow: TvShowEntity)

}