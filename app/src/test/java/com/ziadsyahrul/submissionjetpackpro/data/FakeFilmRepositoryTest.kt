package com.ziadsyahrul.submissionjetpackpro.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.ziadsyahrul.submissionjetpackpro.data.local.LocalDataSource
import com.ziadsyahrul.submissionjetpackpro.data.local.entity.MovieEntity
import com.ziadsyahrul.submissionjetpackpro.data.local.entity.TvShowEntity
import com.ziadsyahrul.submissionjetpackpro.data.remote.ApiResponse
import com.ziadsyahrul.submissionjetpackpro.data.remote.RemoteDatSource
import com.ziadsyahrul.submissionjetpackpro.data.remote.response.mov.ResultsMovie
import com.ziadsyahrul.submissionjetpackpro.data.remote.response.tv.ResultsTv
import com.ziadsyahrul.submissionjetpackpro.util.AppExecutors
import com.ziadsyahrul.submissionjetpackpro.vo.Resource

class FakeFilmRepositoryTest constructor(
    private val remoteData: RemoteDatSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : FilmDataSource {


    override fun getMovie(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieEntity>, List<ResultsMovie>>(appExecutors) {
            override fun loadFromDb(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllMovie(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ResultsMovie>>> =
                remoteData.getMovie()


            override fun saveCallResult(data: List<ResultsMovie>) {
                val moviesList = ArrayList<MovieEntity>()
                for (dataResponse in data) {
                    val movies = MovieEntity(
                        dataResponse.id,
                        dataResponse.title,
                        dataResponse.overview,
                        dataResponse.releaseDate,
                        dataResponse.posterPath,
                        dataResponse.originalLanguage,
                        dataResponse.voteAverage
                    )
                    moviesList.add(movies)
                }
                localDataSource.insertMovie(moviesList)
            }

        }.asLiveData()
    }


    override fun getMovDetail(movId: Int): LiveData<MovieEntity> =
        localDataSource.getMovieById(movId)

    override fun getMovFavorite(): LiveData<PagedList<MovieEntity>> {
        val setting = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(localDataSource.getFavMovie(), setting).build()
    }

    override fun setMovFavorite(movie: MovieEntity) {
        localDataSource.setFavMov(movie)
    }

    override fun getTvShow(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object :
            NetworkBoundResource<PagedList<TvShowEntity>, List<ResultsTv>>(appExecutors) {
            override fun loadFromDb(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllTv(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ResultsTv>>> =
                remoteData.getTvShow()


            override fun saveCallResult(data: List<ResultsTv>) {
                val tvList = ArrayList<TvShowEntity>()
                for (dataResponse in data) {
                    val tv = TvShowEntity(
                        id = dataResponse.id,
                        title = dataResponse.name,
                        overview = dataResponse.overview,
                        posterPath = dataResponse.posterPath,
                        releaseDate = dataResponse.firstAirDate,
                        originalLanguange = dataResponse.originalLanguage,
                        voteAverage = dataResponse.voteAverage,
                        isFav = false
                    )
                    tvList.add(tv)
                }
                localDataSource.insertTvShow(tvList)
            }

        }.asLiveData()
    }


    override fun getTvShowDetail(tvId: Int): LiveData<TvShowEntity> =
        localDataSource.getTvById(tvId)

    override fun getTvFavorite(): LiveData<PagedList<TvShowEntity>> {
        val setting = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(localDataSource.getFavTv(), setting).build()
    }

    override fun setTvFavorite(tvShow: TvShowEntity) {
        localDataSource.setFavTv(tvShow)
    }

}