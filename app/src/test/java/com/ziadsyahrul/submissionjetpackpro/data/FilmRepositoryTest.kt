package com.ziadsyahrul.submissionjetpackpro.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.*
import com.ziadsyahrul.submissionjetpackpro.data.local.LocalDataSource
import com.ziadsyahrul.submissionjetpackpro.data.local.entity.MovieEntity
import com.ziadsyahrul.submissionjetpackpro.data.local.entity.TvShowEntity
import com.ziadsyahrul.submissionjetpackpro.data.remote.RemoteDatSource
import com.ziadsyahrul.submissionjetpackpro.util.AppExecutors
import com.ziadsyahrul.submissionjetpackpro.util.DataDummy
import com.ziadsyahrul.submissionjetpackpro.util.LiveDataTestUtil
import com.ziadsyahrul.submissionjetpackpro.vo.Resource
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class FilmRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var remote = Mockito.mock(RemoteDatSource::class.java)
    private val local = Mockito.mock(LocalDataSource::class.java)
    private val appExecutor = Mockito.mock(AppExecutors::class.java)
    private var filmRepository = FakeFilmRepositoryTest(remote, local, appExecutor)

    private val movieResponse = DataDummy.getResponseMovie()
    private val movId = movieResponse[0].id
    private val movieDetail = DataDummy.getDetailMovResponse()

    private val tvShowResponse = DataDummy.getResponseTvShow()
    private val tvShowId = tvShowResponse[0].id
    private val tvShowDetail = DataDummy.getResponseDetailTvShow()

    fun <T> mockPagedList(list: List<T>): PagedList<T> {
        val pagedList = Mockito.mock(PagedList::class.java) as PagedList<T>
        `when`(pagedList[ArgumentMatchers.anyInt()]).then { invocation ->
            val index = invocation.arguments.first() as Int
            list[index]
        }
        `when`(pagedList.size).thenReturn(list.size)

        return pagedList
    }

    @Test
    fun getMovie() {
       val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovie()).thenReturn(dataSourceFactory)
        filmRepository.getMovie()

        val movieData = Resource.success(mockPagedList(DataDummy.getMovie()))
        verify(local).getAllMovie()
        assertNotNull(movieData)
        assertEquals(movieResponse.size.toLong(), movieData.data?.size?.toLong())
    }

    @Test
    fun getMovDetail() {

        val dummyMovie = MutableLiveData<MovieEntity>()
        dummyMovie.value = DataDummy.getDetailMov()
        `when`(local.getMovieById(movId)).thenReturn(dummyMovie)

        val movieDetailData = LiveDataTestUtil.getValue(filmRepository.getMovDetail(movId))
        verify(local).getMovieById(movId)
        assertNotNull(movieDetailData)
        assertEquals(movieDetail.id, movieDetailData.id)
    }

    @Test
    fun getTvShow() {
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getAllTv()).thenReturn(dataSourceFactory)
        filmRepository.getTvShow()

        val tvData = Resource.success(mockPagedList(DataDummy.getTvShow()))
        verify(local).getAllTv()
        assertNotNull(tvData)
        assertEquals(tvShowResponse.size.toLong(), tvData.data?.size?.toLong())
    }

    @Test
    fun getTvShowDetail() {
        val dummyTv = MutableLiveData<TvShowEntity>()
        dummyTv.value = DataDummy.getTvDetail()
        `when`(local.getTvById(tvShowId)).thenReturn(dummyTv)

        val tvDetailData = LiveDataTestUtil.getValue(filmRepository.getTvShowDetail(tvShowId))
        verify(local).getTvById(tvShowId)
        assertNotNull(tvDetailData)
        assertEquals(tvShowDetail.id, tvDetailData.id)
    }
}