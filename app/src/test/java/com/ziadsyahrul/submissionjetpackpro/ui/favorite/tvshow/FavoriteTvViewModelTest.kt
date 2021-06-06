package com.ziadsyahrul.submissionjetpackpro.ui.favorite.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
import com.ziadsyahrul.submissionjetpackpro.data.FilmRepository
import com.ziadsyahrul.submissionjetpackpro.data.local.entity.TvShowEntity
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteTvViewModelTest {

    private lateinit var viewModelTv: FavoriteTvViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observerTv: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var pagedListTv: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModelTv = FavoriteTvViewModel(filmRepository)
    }

    @Test
    fun getFavTvShows() {
        val dummyTv = pagedListTv
        `when`(dummyTv.size).thenReturn(3)
        val tv = MutableLiveData<PagedList<TvShowEntity>>()
        tv.value = dummyTv

        `when`(filmRepository.getTvFavorite()).thenReturn(tv)
        val tvSHows = viewModelTv.getFavTvShows().value
        verify(filmRepository).getTvFavorite()
        assertNotNull(tvSHows)
        assertEquals(3, tvSHows?.size)

        viewModelTv.getFavTvShows().observeForever(observerTv)
        verify(observerTv).onChanged(dummyTv)

    }

}