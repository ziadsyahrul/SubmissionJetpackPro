package com.ziadsyahrul.submissionjetpackpro.ui.detail

import com.ziadsyahrul.submissionjetpackpro.util.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.getMovie()[0]
    private val movieId = dummyMovie.id
    private val dummyTvShow = DataDummy.getTvShow()[0]
    private val tvShowId = dummyTvShow.id

    @Before
    fun setUpMov(){
        viewModel = DetailViewModel()
        viewModel.setMovie(movieId, "movie")
    }

    @Test
    fun getMovDetail() {
        viewModel.setMovie(dummyMovie.id, "movie")
        val movie = viewModel.getFilmDetail()
        assertNotNull(movie)
        assertEquals(dummyMovie.id, movie.id)
        assertEquals(dummyMovie.title, movie.title)
        assertEquals(dummyMovie.description, movie.description)
        assertEquals(dummyMovie.genre, movie.genre)
        assertEquals(dummyMovie.year, movie.year)
        assertEquals(dummyMovie.poster, movie.poster)
    }

    @Before
    fun setUpTv(){
        viewModel = DetailViewModel()
        viewModel.setMovie(tvShowId, "tvshow")

    }

    @Test
    fun getTvDetail(){
        viewModel.setMovie(dummyTvShow.id, "tvshow")
        val tvShow = viewModel.getFilmDetail()
        assertNotNull(tvShow)
        assertEquals(dummyTvShow.id, tvShow.id)
        assertEquals(dummyTvShow.title, tvShow.title)
        assertEquals(dummyTvShow.description, tvShow.description)
        assertEquals(dummyTvShow.genre, tvShow.genre)
        assertEquals(dummyTvShow.year, tvShow.year)
        assertEquals(dummyTvShow.poster, tvShow.poster)
    }

}