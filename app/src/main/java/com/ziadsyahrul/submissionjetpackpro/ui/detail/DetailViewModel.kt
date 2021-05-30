package com.ziadsyahrul.submissionjetpackpro.ui.detail

import androidx.lifecycle.ViewModel
import com.ziadsyahrul.submissionjetpackpro.model.MovieModel
import com.ziadsyahrul.submissionjetpackpro.util.DataDummy

class DetailViewModel: ViewModel() {

    private lateinit var film: MovieModel

    companion object{
        const val TV_SHOW = "tvshow"
        const val MOVIE = "movie"
    }

    fun setMovie(id: String, category: String){
        when(category){
            TV_SHOW -> {
                for (tvShow in DataDummy.getTvShow()){
                    if (tvShow.id == id) film = tvShow
                }
            }

            MOVIE -> {
                for (movie in DataDummy.getMovie()){
                    if (movie.id == id) film = movie
                }
            }
        }
    }

    fun getFilmDetail() = film

}