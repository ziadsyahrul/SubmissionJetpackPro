package com.ziadsyahrul.submissionjetpackpro.di

import android.content.Context
import com.ziadsyahrul.submissionjetpackpro.data.FilmRepository
import com.ziadsyahrul.submissionjetpackpro.data.local.LocalDataSource
import com.ziadsyahrul.submissionjetpackpro.data.local.room.CatalogueDatabase
import com.ziadsyahrul.submissionjetpackpro.data.remote.RemoteDatSource
import com.ziadsyahrul.submissionjetpackpro.util.AppExecutors

object Injection {
    fun provideRepository(context: Context): FilmRepository{

        val database = CatalogueDatabase.getInstance(context)

        val remoteData = RemoteDatSource.getInstance()
        val localData = LocalDataSource.getInstance(database.catalogueDao())
        val appExe = AppExecutors()
        return FilmRepository.getInstance(remoteData, localData, appExe)
    }
}