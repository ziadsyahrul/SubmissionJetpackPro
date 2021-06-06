package com.ziadsyahrul.submissionjetpackpro.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.ziadsyahrul.submissionjetpackpro.R
import com.ziadsyahrul.submissionjetpackpro.util.DataDummy
import com.ziadsyahrul.submissionjetpackpro.util.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest{


    private val dummyMovie = DataDummy.getMovie()
    private val dummyTv = DataDummy.getTvShow()


    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Before
    fun setUp(){
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }


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
      * Memastikan data title untuk tampil
      * Memastikan data releasedate untuk tampil
      * Memastikan data description untuk tampil
      * Memastikan postermovie untuk tampil
     */
    @Test
    fun loadDetailMov(){
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.judul)).check(matches(isDisplayed()))
        onView(withId(R.id.release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.description)).check(matches(isDisplayed()))
        onView(withId(R.id.poster)).check(matches(isDisplayed()))
    }


    /**
     Show Favorite Movie
      * Memberi tindakan klik pada menu favorite
      * Memastikan rv_fav_movie dalam keadaan tampil
      * Scroll rv_fav_movie ke baris paling akhir
     */
    @Test
    fun loadFavoriteMovie(){
        onView(withId(R.id.menu)).perform(click())
        onView(withId(R.id.rv_fav_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_fav_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }


    /**
     Show Detail Favorite Movie
      * Memastikan rv-movie dalam keadaan tampil
      * Memberi tindakan pada data pertama di rv_movie
      * memberi tindakan klik pada floatingactionbutton untuk menambahkan ke favorite
      * memberi tindakan klik pada menu favorite
      * memastikan rv_fav_movie dalam keadaan tampil
      * memberi tindakan klik pada data pertama di rv_fav_movie
      * memastikan data judul,release_date,description,dan poster dalam keadaan tampil
      * memberi tindakan klik pada floatingactionbutton untuk menghapus dari favorite
     */
    @Test
    fun loadFavoriteMovDetail(){
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.floatingActionButton)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())

        onView(withId(R.id.menu)).perform(click())
        onView(withId(R.id.rv_fav_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_fav_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.judul)).check(matches(isDisplayed()))
        onView(withId(R.id.release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.description)).check(matches(isDisplayed()))
        onView(withId(R.id.poster)).check(matches(isDisplayed()))
        onView(withId(R.id.floatingActionButton)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
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
     * Memastikan data title untuk tampil
     * Memastikan data genre genre untuk tampil
     * Memastikan data overview untuk tampil
     * MEmastikan postertv untuk tampil
     */
    @Test
    fun loadDetailTv(){
        onView(withText(R.string.tvshow)).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.judul)).check(matches(isDisplayed()))
        onView(withId(R.id.release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.description)).check(matches(isDisplayed()))
        onView(withId(R.id.poster)).check(matches(isDisplayed()))
    }


    /**
    Show Favorite TvShow
     * Memberi tindakan klik pada menu favorite
     * berpindah ke tab tvshow
     * Memastikan rv_fav_tvshow dalam keadaan tampil
     * Scroll rv_fav_tvshow ke baris paling akhir
     */
    @Test
    fun loadFavoriteTvShow(){
        onView(withId(R.id.menu)).perform(click())
        onView(withText(R.string.tvshow)).perform(click())
        onView(withId(R.id.rv_fav_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_fav_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }


    /**
    Show Detail Favorite TvShow
     * berpindah ke tab tvShow
     * Memastikan rv_tvshow dalam keadaan tampil
     * Memberi tindakan klik pada data pertama di rv_tvshow
     * memberi tindakan klik pada floatingactionbutton untuk menambahkan ke favorite
     * memberi tindakan klik pada menu favorite
     * berpindah ke tab tvshow
     * memberi tindakan klik pada data pertama di rv_fav_tvshow
     * memastikan data judul,release_date,description,dan poster dalam keadaan tampil
     * Memberikan tindakan klik pada floatingactionbutton untuk menghapus dari favorite
     */
    @Test
    fun loadFavoriteTvDetail(){
        onView(withText(R.string.tvshow)).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.floatingActionButton)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())

        onView(withId(R.id.menu)).perform(click())
        onView(withText(R.string.tvshow)).perform(click())
        onView(withId(R.id.rv_fav_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.judul)).check(matches(isDisplayed()))
        onView(withId(R.id.release_date)).check(matches(isDisplayed()))
        onView(withId(R.id.description)).check(matches(isDisplayed()))
        onView(withId(R.id.poster)).check(matches(isDisplayed()))
        onView(withId(R.id.floatingActionButton)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
    }
}