package com.ziadsyahrul.submissionjetpackpro.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.ziadsyahrul.submissionjetpackpro.data.FilmRepository
import com.ziadsyahrul.submissionjetpackpro.data.local.entity.MovieEntity
import com.ziadsyahrul.submissionjetpackpro.data.local.entity.TvShowEntity
import com.ziadsyahrul.submissionjetpackpro.util.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel

    private val dummyMovie = DataDummy.getDetailMov()
    private val dummyMovId = dummyMovie.id

    private val dummyTvShow = DataDummy.getTvDetail()
    private val dummyTvId = dummyTvShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observerMov: Observer<MovieEntity>

    @Mock
    private lateinit var observerTv: Observer<TvShowEntity>



    // GET MOVIE TESTING
    @Before
    fun setUpMov(){
        viewModel = DetailViewModel(filmRepository)
    }

    @Test
    fun getMovDetail() {
        val dummyMov = MutableLiveData<MovieEntity>()
        dummyMov.value = dummyMovie

        `when`(filmRepository.getMovDetail(dummyMovId)).thenReturn(dummyMov)

        val movieData = viewModel.getMovDetail(dummyMovId).value

        assertNotNull(movieData)
        assertEquals(dummyMovie.id, movieData?.id)
        assertEquals(dummyMovie.title, movieData?.title)
        assertEquals(dummyMovie.overview, movieData?.overview)
        assertEquals(dummyMovie.releaseDate, movieData?.releaseDate)
        assertEquals(dummyMovie.posterPath, movieData?.posterPath)

        viewModel.getMovDetail(dummyMovId).observeForever(observerMov)
        verify(observerMov).onChanged(dummyMovie)

    }

    // GET TV TESTING
    @Before
    fun setUpTv(){
        viewModel = DetailViewModel(filmRepository)

    }

    @Test
    fun getTvDetail(){
        val tvShow = MutableLiveData<TvShowEntity>()
        tvShow.value = dummyTvShow

        `when`(filmRepository.getTvShowDetail(dummyTvId)).thenReturn(tvShow)

        val tvShowData = viewModel.getTvDetail(dummyTvId).value

        assertNotNull(tvShowData)
        assertEquals(dummyTvShow.id, tvShowData?.id)
        assertEquals(dummyTvShow.title, tvShowData?.title)
        assertEquals(dummyTvShow.overview, tvShowData?.overview)
        assertEquals(dummyTvShow.releaseDate, tvShowData?.releaseDate)
        assertEquals(dummyTvShow.posterPath, tvShowData?.posterPath)

        viewModel.getTvDetail(dummyTvId).observeForever(observerTv)
        verify(observerTv).onChanged(dummyTvShow)
    }

}