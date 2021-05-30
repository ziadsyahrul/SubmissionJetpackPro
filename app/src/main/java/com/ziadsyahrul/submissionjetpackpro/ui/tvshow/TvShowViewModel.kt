package com.ziadsyahrul.submissionjetpackpro.ui.tvshow

import androidx.lifecycle.ViewModel
import com.ziadsyahrul.submissionjetpackpro.util.DataDummy

class TvShowViewModel: ViewModel() {
    fun getTvShow() = DataDummy.getTvShow()
}