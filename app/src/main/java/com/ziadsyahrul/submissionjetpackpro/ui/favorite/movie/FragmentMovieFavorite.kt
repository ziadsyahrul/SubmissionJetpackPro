package com.ziadsyahrul.submissionjetpackpro.ui.favorite.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ziadsyahrul.submissionjetpackpro.databinding.FragmentMovieFavoriteBinding
import com.ziadsyahrul.submissionjetpackpro.viewModel.ViewModelFactory


class FragmentMovieFavorite : Fragment() {

    private var fragmentMovieFavoriteBinding: FragmentMovieFavoriteBinding? = null
    private val binding get() = fragmentMovieFavoriteBinding

    private lateinit var viewModel: FavoriteMovieViewModel
    private lateinit var adapter: FavoriteMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentMovieFavoriteBinding = FragmentMovieFavoriteBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getFavoriteMovie().observe(viewLifecycleOwner, { movFavorite ->
            if (movFavorite != null){
                adapter.submitList(movFavorite)
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteMovieViewModel::class.java]

            adapter = FavoriteMovieAdapter()

            viewModel.getFavoriteMovie().observe(viewLifecycleOwner, { movieFav ->
                if (movieFav != null){
                    adapter.submitList(movieFav)
                }
            })

            with(binding?.rvFavMovie){
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = adapter
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentMovieFavoriteBinding = null
    }

}