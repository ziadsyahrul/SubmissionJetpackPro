package com.ziadsyahrul.submissionjetpackpro.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.ziadsyahrul.submissionjetpackpro.R
import com.ziadsyahrul.submissionjetpackpro.databinding.ActivityMainBinding
import com.ziadsyahrul.submissionjetpackpro.ui.favorite.FavoriteActivity

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


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.clear()
        menuInflater.inflate(R.menu.menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu -> {
                val intent = Intent(this, FavoriteActivity::class.java)
                startActivity(intent)
            }

        }
        return super.onOptionsItemSelected(item)
    }
}