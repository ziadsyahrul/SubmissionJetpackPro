package com.ziadsyahrul.submissionjetpackpro.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import com.ziadsyahrul.submissionjetpackpro.R
import com.ziadsyahrul.submissionjetpackpro.data.local.entity.MovieEntity
import com.ziadsyahrul.submissionjetpackpro.data.local.entity.TvShowEntity
import com.ziadsyahrul.submissionjetpackpro.databinding.ActivityDetailBinding
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
            viewModel.getMovDetail(id).observe(this, Observer {
                populateDetail(it, null)
            })

        } else if (type.equals("TVSHOW_TYPE", ignoreCase = true)) {
            viewModel.getTvDetail(id).observe(this, Observer {
                populateDetail(null, it)
            })
        }

    }

    private fun populateDetail(movie: MovieEntity?, tvShow: TvShowEntity?) {
        binding.judul.text = movie?.title ?: tvShow?.title
        binding.description.text = movie?.overview ?: tvShow?.overview
        binding.releaseDate.text = movie?.releaseDate ?: tvShow?.releaseDate
        val statusFav = movie?.isFav ?: tvShow?.isFav
        val urlImage = movie?.posterPath ?: tvShow?.posterPath

        Picasso.get().load("https://image.tmdb.org/t/p/w500/" + urlImage)
            .into(binding.poster)

        statusFav?.let { status ->
            setFavoriteState(status)
        }

        binding.floatingActionButton.setOnClickListener {
            setFavorite(movie, tvShow)
        }
    }

    private fun setFavoriteState(status: Boolean){
        if (status) {
            binding.floatingActionButton.setImageResource(R.drawable.ic_favorite)
        }else{
            binding.floatingActionButton.setImageResource(R.drawable.ic_favorite_border)
        }
    }

    private fun setFavorite(movie: MovieEntity?, tvShow: TvShowEntity?){
        if (movie != null) {
            if (movie.isFav){
                showSnackbar("${movie.title} Removed from favorite")
            }else {
                showSnackbar("${movie.title} Added to favorite")
            }
            viewModel.setFavMovie(movie)
        } else {
            if (tvShow != null) {
                if (tvShow.isFav){
                    showSnackbar("${tvShow.title} Removed from favorite")
                }else {
                    showSnackbar("${tvShow.title} Added from favorite")
                }
                viewModel.setFavTv(tvShow)
            }
        }
    }

    private fun showSnackbar(message: String){
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show()
    }

}