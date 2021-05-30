package com.ziadsyahrul.submissionjetpackpro.ui.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ziadsyahrul.submissionjetpackpro.databinding.FragmentTvShowBinding
import com.ziadsyahrul.submissionjetpackpro.model.MovieModel


class TvShowFragment : Fragment() {

    private lateinit var binding: FragmentTvShowBinding
    private val tvShow: ArrayList<MovieModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null){
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvShowViewModel::class.java]
            val tvShows = viewModel.getTvShow()

            val tvShowAdapter = TvShowAdapter(tvShow)
            tvShowAdapter.setTvShow(tvShows)

            with(binding.rvTvshow){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }


}