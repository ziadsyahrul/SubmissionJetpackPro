package com.ziadsyahrul.submissionjetpackpro.ui.tvshow

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp(){
        viewModel = TvShowViewModel()
    }

    @Test
    fun getTvShow() {
        val tvShow = viewModel.getTvShow()
        assertNotNull(tvShow)
        assertEquals(10, tvShow.size)
    }
}