package com.ziadsyahrul.submissionjetpackpro.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.ziadsyahrul.submissionjetpackpro.R
import com.ziadsyahrul.submissionjetpackpro.util.DataDummy
import org.junit.Rule
import org.junit.Test

class MainActivityTest{


    private val dummyMovie = DataDummy.getMovie()
    private val dummyTv = DataDummy.getTvShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)


    /**
     Show Movie Data
      * Memastikan rv_movie dalam keadaan tampil
      * scroll rv_movie ke baris paling akhir
     */
    @Test
    fun loadMov(){
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    /**
     Show Detail Data Movie
      * Memberi tindakan klik pada data pertama di rv_movie
      * Memastikan textView untuk title tampil dengan sesuai harapan
      * Memastikan textView untuk genre tampil dengan sesuai harapan
      * Memastikan textView untuk description tampil dengan sesuai harapan
     */
    @Test
    fun loadDetailMov(){
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.judul)).check(matches(isDisplayed()))
        onView(withId(R.id.judul)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.genre)).check(matches(isDisplayed()))
        onView(withId(R.id.genre)).check(matches(withText(dummyMovie[0].genre)))
        onView(withId(R.id.description)).check(matches(isDisplayed()))
        onView(withId(R.id.description)).check(matches(withText(dummyMovie[0].description)))
    }

    /**
     Show TvShow Data
     * Memastikan rv_tvshow tampil
     * scroll rv_tvshow ke baris paling akhir
     */
    @Test
    fun loadTv(){
        onView(withText(R.string.tvshow)).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTv.size))
    }

    /**
    Show Detail Data TvShow
     * Memberi tindakan klik pada data pertama di rv_tvshow
     * Memastikan textView untuk title tampil dengan sesuai harapan
     * Memastikan textView untuk genre tampil dengan sesuai harapan
     * Memastikan textView untuk description tampil dengan sesuai harapan
     */
    @Test
    fun loadDetailTv(){
        onView(withText(R.string.tvshow)).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.judul)).check(matches(isDisplayed()))
        onView(withId(R.id.judul)).check(matches(withText(dummyTv[0].title)))
        onView(withId(R.id.genre)).check(matches(isDisplayed()))
        onView(withId(R.id.genre)).check(matches(withText(dummyTv[0].genre)))
        onView(withId(R.id.description)).check(matches(isDisplayed()))
        onView(withId(R.id.description)).check(matches(withText(dummyTv[0].description)))
    }
}