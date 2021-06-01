package com.ziadsyahrul.submissionjetpackpro.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ziadsyahrul.submissionjetpackpro.data.local.DetailModel
import com.ziadsyahrul.submissionjetpackpro.data.local.MovieModel
import com.ziadsyahrul.submissionjetpackpro.data.local.TvShowModel
import com.ziadsyahrul.submissionjetpackpro.data.remote.RemoteDatSource
import com.ziadsyahrul.submissionjetpackpro.data.remote.response.mov.DetailMovResponse
import com.ziadsyahrul.submissionjetpackpro.data.remote.response.mov.ResultsItem
import com.ziadsyahrul.submissionjetpackpro.data.remote.response.tv.TvShowDetailResponse

class FilmRepository private constructor(private val remoteData: RemoteDatSource): FilmDataSource{

    companion object{
        @Volatile
        private var instance: FilmRepository? = null

        fun getInstance(remoteData: RemoteDatSource): FilmRepository =
                instance ?: synchronized(this) {
                    instance ?: FilmRepository(remoteData)
                }
    }


    override fun getMovie(): LiveData<List<MovieModel>> {
        val movieResult = MutableLiveData<List<MovieModel>>()

        remoteData.getMovie(object : RemoteDatSource.LoadMovieCallBack {
            override fun onAllMovieReceived(movieResponse: List<ResultsItem>?) {
                val movieList = ArrayList<MovieModel>()
                if ( movieResponse != null){
                    for (response in movieResponse) {
                        with(response){
                            val movie = MovieModel(id, title, posterPath, releaseDate)
                            movieList.add(movie)
                        }
                    }
                    movieResult.postValue(movieList)
                }
            }

        })
        return movieResult
    }

    override fun getMovDetail(movId: String): LiveData<DetailModel> {
        val movieDetailResult = MutableLiveData<DetailModel>()

        remoteData.getDetailMov(object : RemoteDatSource.LoadDetailMovCallBack {
            override fun onDetailMovReceived(movieResponse: DetailMovResponse?) {
                if(movieResponse != null){
                    with(movieResponse){
                        val listGenre = ArrayList<String>()
                        for (genre in genres) {
                            listGenre.add(genre.name)
                        }

                        val detailMov = DetailModel(
                                genres = listGenre,
                                id = id,
                                overview = overview,
                                posterPath = posterPath,
                                releaseDate = releaseDate,
                                title = title
                        )
                        movieDetailResult.postValue(detailMov)
                    }
                }
            }

        }, movId)
        return movieDetailResult
    }

    override fun getTvShow(): LiveData<List<TvShowModel>> {
        val tvResult = MutableLiveData<List<TvShowModel>>()

        remoteData.getTvShow(object : RemoteDatSource.LoadTvShowCallBack {
            override fun onAllTvShowReceived(tvShowResponse: List<com.ziadsyahrul.submissionjetpackpro.data.remote.response.tv.ResultsItem>?) {
                val tvList = ArrayList<TvShowModel>()
                if (tvShowResponse != null){
                    for (response in tvShowResponse){
                        with(response){
                            val tvShow = TvShowModel(id, name, posterPath, firstAirDate)
                            tvList.add(tvShow)
                        }
                    }
                }
            }

        })
        return tvResult
    }

    override fun getTvShowDetail(tvId: String): LiveData<DetailModel> {
        val movDetailResult = MutableLiveData<DetailModel>()

        remoteData.getTvshowDetail(object : RemoteDatSource.LoadTvShowDetailCallBack {
            override fun onDetailTvShowReceived(tvShowResponse: TvShowDetailResponse?) {
                if (tvShowResponse != null){
                    with(tvShowResponse) {
                        val listGenre = ArrayList<String>()

                        for (genre in genres){
                            listGenre.add(genre.name)
                        }

                        val detailMov = DetailModel(
                                genres = listGenre,
                                id = id,
                                overview = overview,
                                posterPath = posterPath,
                                releaseDate = firstAirDate,
                                title = name
                        )
                        movDetailResult.postValue(detailMov)
                    }
                }
            }

        }, tvId)
        return movDetailResult
    }

}