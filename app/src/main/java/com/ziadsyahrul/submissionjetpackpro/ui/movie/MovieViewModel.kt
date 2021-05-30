package com.ziadsyahrul.submissionjetpackpro.ui.movie

import androidx.lifecycle.ViewModel
import com.ziadsyahrul.submissionjetpackpro.util.DataDummy

class MovieViewModel: ViewModel() {
    fun getMoviess() = DataDummy.getMovie()
}