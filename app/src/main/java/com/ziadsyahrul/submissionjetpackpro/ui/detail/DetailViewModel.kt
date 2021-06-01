package com.ziadsyahrul.submissionjetpackpro.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ziadsyahrul.submissionjetpackpro.data.FilmRepository
import com.ziadsyahrul.submissionjetpackpro.data.local.DetailModel
import com.ziadsyahrul.submissionjetpackpro.data.local.MovieModel
import com.ziadsyahrul.submissionjetpackpro.util.DataDummy

class DetailViewModel(private val filmRepository: FilmRepository): ViewModel() {

    private lateinit var film: LiveData<DetailModel>

    companion object{
        const val TV_SHOW = "tvshow"
        const val MOVIE = "movie"
    }

    fun setMovie(id: String, category: String){
        when(category){
            TV_SHOW -> {
                film = filmRepository.getTvShowDetail(id)
            }

            MOVIE -> {
                film = filmRepository.getMovDetail(id)
            }
        }
    }

    fun getFilmDetail() = film

}