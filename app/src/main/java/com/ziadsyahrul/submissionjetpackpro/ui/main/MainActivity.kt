package com.ziadsyahrul.submissionjetpackpro.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ziadsyahrul.submissionjetpackpro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionPager = SectionPagerAdapter(this, supportFragmentManager)
        binding.viewPager.adapter = sectionPager
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        supportActionBar?.elevation = 0f
    }
}