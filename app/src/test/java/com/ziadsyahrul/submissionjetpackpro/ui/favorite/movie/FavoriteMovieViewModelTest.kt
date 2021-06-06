package com.ziadsyahrul.submissionjetpackpro.ui.favorite.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
import com.ziadsyahrul.submissionjetpackpro.data.FilmRepository
import com.ziadsyahrul.submissionjetpackpro.data.local.entity.MovieEntity
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteMovieViewModelTest {

    private lateinit var viewModelMovie: FavoriteMovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observerMovie: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp(){
        viewModelMovie = FavoriteMovieViewModel(filmRepository)
    }

    @Test
    fun getFavoriteMovie() {
        val dummyMov = pagedList
        `when`(dummyMov.size).thenReturn(3)
        val movie = MutableLiveData<PagedList<MovieEntity>>()
        movie.value = dummyMov

        `when`(filmRepository.getMovFavorite()).thenReturn(movie)
        val movies = viewModelMovie.getFavoriteMovie().value
        verify(filmRepository).getMovFavorite()
        assertNotNull(movies)
        assertEquals(3, movies?.size)

        viewModelMovie.getFavoriteMovie().observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMov)
    }

}