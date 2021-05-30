package com.ziadsyahrul.submissionjetpackpro.ui.main

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ziadsyahrul.submissionjetpackpro.R
import com.ziadsyahrul.submissionjetpackpro.ui.movie.MoviesFragment
import com.ziadsyahrul.submissionjetpackpro.ui.tvshow.TvShowFragment

class SectionPagerAdapter(private val mContext: Context, fm: FragmentManager): FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object{
        @StringRes
        private val TABS_TITLE = intArrayOf(R.string.movie, R.string.tvshow)
    }

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment =
        when(position){
            0 -> MoviesFragment()
            1 -> TvShowFragment()
            else -> MoviesFragment()
        }


    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(TABS_TITLE[position])
}