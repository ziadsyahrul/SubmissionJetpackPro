package com.ziadsyahrul.submissionjetpackpro.ui.movie

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        viewModel = MovieViewModel()
    }

    @Test
    fun getMoviess() {
        val movie = viewModel.getMoviess()
        assertNotNull(movie)
        assertEquals(10, movie.size)
    }
}