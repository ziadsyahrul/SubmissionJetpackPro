package com.ziadsyahrul.submissionjetpackpro.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ziadsyahrul.submissionjetpackpro.databinding.FragmentMoviesBinding
import com.ziadsyahrul.submissionjetpackpro.model.MovieModel


class MoviesFragment : Fragment() {

    private lateinit var binding: FragmentMoviesBinding
    private val movies: ArrayList<MovieModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]
            val movie = viewModel.getMoviess()

            val movAdapter = MovieAdapter(movies)
            movAdapter.setMovie(movie)

            with(binding.rvMovie){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movAdapter
            }

        }
    }

}