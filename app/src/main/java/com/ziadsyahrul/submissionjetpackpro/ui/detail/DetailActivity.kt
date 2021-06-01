package com.ziadsyahrul.submissionjetpackpro.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import com.ziadsyahrul.submissionjetpackpro.data.local.DetailModel
import com.ziadsyahrul.submissionjetpackpro.data.local.MovieModel
import com.ziadsyahrul.submissionjetpackpro.databinding.ActivityDetailBinding
import com.ziadsyahrul.submissionjetpackpro.viewModel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object{
        const val EXTRA_FILM = "extra_film"
        const val EXTRA_CATEGORY = "extra_category"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val id = intent.getIntExtra(EXTRA_FILM, 0)
        val type = intent.getStringExtra(EXTRA_CATEGORY)

        if (type.equals("TYPE_MOVIE", ignoreCase = true)) {
            if (id != null) {
                viewModel.getMovDetail(id).observe(this, Observer {
                    populateDetail(it)
                })
            }

        } else if (type.equals("TYPE_TVSHOW", ignoreCase = true)){
            if (id != null) {
                viewModel.getTvDetail(id).observe(this, Observer {
                    populateDetail(it)
                })
            }
            }



//        val extra = intent.extras
//        if (extra != null){
//
//            val dataId = extra.getString(EXTRA_FILM)
//            val dataCategory = extra.getString(EXTRA_CATEGORY)
//
//            if (dataId != null && dataCategory != null){
//                viewModel.setMovie(dataId, dataCategory)
//                viewModel.getFilmDetail().observe(this, { detail ->
//                    populateDetail(detail)
//                })
//            }
//        }
    }

    private fun populateDetail(film: DetailModel) {
        binding.judul.text = film.title
        binding.description.text = film.overview
        binding.genre.text = film.genres.toString()
        Picasso.get().load("https://image.tmdb.org/t/p/w500/" + film.posterPath).into(binding.poster)
        binding.poster.tag = film.posterPath
    }


}