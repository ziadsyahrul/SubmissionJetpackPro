package com.ziadsyahrul.submissionjetpackpro.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import com.ziadsyahrul.submissionjetpackpro.databinding.ActivityDetailBinding
import com.ziadsyahrul.submissionjetpackpro.model.MovieModel

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

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val extra = intent.extras
        if (extra != null){
            val dataId = extra.getString(EXTRA_FILM)
            val dataCategory = extra.getString(EXTRA_CATEGORY)

            if (dataId != null && dataCategory != null){
                viewModel.setMovie(dataId, dataCategory)
                val film = viewModel.getFilmDetail()
                populateDetail(film)
            }
        }
    }

    private fun populateDetail(film: MovieModel) {
        binding.judul.text = film.title
        binding.description.text = film.description
        binding.genre.text = film.genre
        Picasso.get().load(film.poster).into(binding.poster)
    }


}