package com.ziadsyahrul.submissionjetpackpro.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ziadsyahrul.submissionjetpackpro.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionPager = FavoritePagerAdapter(this, supportFragmentManager)
        binding.viewPagerFavorite.adapter = sectionPager
        binding.tabLayoutFavorite.setupWithViewPager(binding.viewPagerFavorite)

        supportActionBar?.elevation = 0f
    }
}