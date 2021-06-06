package com.ziadsyahrul.submissionjetpackpro.ui.favorite.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ziadsyahrul.submissionjetpackpro.databinding.FragmentTvShowFavoriteBinding
import com.ziadsyahrul.submissionjetpackpro.viewModel.ViewModelFactory


class FragmentTvShowFavorite : Fragment() {

    private var _fragmentTvShowBinding: FragmentTvShowFavoriteBinding? = null
    private val binding get() = _fragmentTvShowBinding

    private lateinit var viewModel: FavoriteTvViewModel
    private lateinit var adapter: FavoriteTvAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _fragmentTvShowBinding = FragmentTvShowFavoriteBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteTvViewModel::class.java]

            adapter = FavoriteTvAdapter()

            viewModel.getFavTvShows().observe(viewLifecycleOwner, { tvshowFavorite ->
                if (tvshowFavorite != null){
                    adapter.submitList(tvshowFavorite)
                }
            })

            with(binding?.rvFavTvshow){
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = adapter
            }
        }
    }
}