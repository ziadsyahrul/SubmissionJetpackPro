package com.ziadsyahrul.submissionjetpackpro.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ziadsyahrul.submissionjetpackpro.data.FilmRepository
import com.ziadsyahrul.submissionjetpackpro.di.Injection
import com.ziadsyahrul.submissionjetpackpro.ui.detail.DetailViewModel
import com.ziadsyahrul.submissionjetpackpro.ui.movie.MovieViewModel
import com.ziadsyahrul.submissionjetpackpro.ui.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val filmRepository: FilmRepository): ViewModelProvider.NewInstanceFactory() {
    companion object{
        @Volatile
        private var instance :ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(filmRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(filmRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(filmRepository) as T
            }
            else -> throw Throwable("unknown viewmodel class: " + modelClass.name)
        }
    }
}