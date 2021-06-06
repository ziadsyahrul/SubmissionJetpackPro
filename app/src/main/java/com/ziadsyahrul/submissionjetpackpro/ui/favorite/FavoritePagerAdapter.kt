package com.ziadsyahrul.submissionjetpackpro.ui.favorite

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ziadsyahrul.submissionjetpackpro.R
import com.ziadsyahrul.submissionjetpackpro.ui.favorite.movie.FragmentMovieFavorite
import com.ziadsyahrul.submissionjetpackpro.ui.favorite.tvshow.FragmentTvShowFavorite

class FavoritePagerAdapter(private val context: Context, fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object{
        @StringRes
        private val TABS_TITLE = intArrayOf(R.string.movie, R.string.tvshow)
    }

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment =
        when(position){
            0 -> FragmentMovieFavorite()
            1 -> FragmentTvShowFavorite()
            else -> FragmentMovieFavorite()
        }

    override fun getPageTitle(position: Int): CharSequence?  = context.resources.getString(TABS_TITLE[position])
}