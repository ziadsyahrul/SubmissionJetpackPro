package com.ziadsyahrul.submissionjetpackpro.di

import android.content.Context
import com.ziadsyahrul.submissionjetpackpro.data.FilmRepository
import com.ziadsyahrul.submissionjetpackpro.data.remote.RemoteDatSource

object Injection {
    fun provideRepository(context: Context): FilmRepository{
        val remoteData = RemoteDatSource.getInstance()
        return FilmRepository.getInstance(remoteData)
    }
}