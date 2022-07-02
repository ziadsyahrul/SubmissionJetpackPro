package com.ziadsyahrul.submissionjetpackpro.ui.detail

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import com.ziadsyahrul.submissionjetpackpro.R
import com.ziadsyahrul.submissionjetpackpro.data.local.entity.MovieEntity
import com.ziadsyahrul.submissionjetpackpro.data.local.entity.TvShowEntity
import com.ziadsyahrul.submissionjetpackpro.databinding.ActivityDetailBinding
import com.ziadsyahrul.submissionjetpackpro.util.Constant
import com.ziadsyahrul.submissionjetpackpro.viewModel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val EXTRA_FILM = "extra_film"
        const val EXTRA_CATEGORY = "extra_category"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val id = intent.getIntExtra(EXTRA_FILM, 0)
        val type = intent.getStringExtra(EXTRA_CATEGORY)

        if (type.equals("MOVIE_TYPE", ignoreCase = true)) {
            viewModel.getMovDetail(id).observe(this,  {
                populateDetail(it, null)
            })

        } else if (type.equals("TVSHOW_TYPE", ignoreCase = true)) {
            viewModel.getTvDetail(id).observe(this,  {
                populateDetail(null, it)
            })
        }

    }

    private fun populateDetail(movie: MovieEntity?, tvShow: TvShowEntity?) {
        binding.judul.text = movie?.title ?: tvShow?.title
        binding.description.text = movie?.overview ?: tvShow?.overview
        binding.releaseDate.text = movie?.releaseDate ?: tvShow?.releaseDate
        binding.originalLanguange.text = movie?.originalLanguange ?: tvShow?.originalLanguange
        val statusFav = movie?.isFav ?: tvShow?.isFav
        val urlImage = movie?.posterPath ?: tvShow?.posterPath

        Picasso.get().load(Constant.base_url_image + urlImage)
            .into(binding.poster)

        statusFav?.let { status ->
            setFavoriteState(status)
        }

        binding.floatingActionButton.setOnClickListener {
            setFavorite(movie, tvShow)
        }
    }

    private fun setFavoriteState(status: Boolean) {
        if (status) {
            binding.floatingActionButton.setImageResource(R.drawable.ic_favorite)
        } else {
            binding.floatingActionButton.setImageResource(R.drawable.ic_favorite_border)
        }
    }

    private fun setFavorite(movie: MovieEntity?, tvShow: TvShowEntity?) {
        if (movie != null) {
            if (movie.isFav) {
                showSnackbar("${movie.title} Remove from favorite")
            } else {
                showSnackbar("${movie.title} Added to favorite")
            }
            viewModel.setFavMovie(movie)
        } else {
            if (tvShow != null) {
                if (tvShow.isFav) {
                    showSnackbar("${tvShow.title} Remove from favorite")
                } else {
                    showSnackbar("${tvShow.title} Added from favorite")
                }
                viewModel.setFavTv(tvShow)
            }
        }
    }

    private fun showSnackbar(message: String) {
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show()
    }



}