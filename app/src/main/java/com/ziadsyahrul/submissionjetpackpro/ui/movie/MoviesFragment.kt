package com.ziadsyahrul.submissionjetpackpro.ui.movie

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ziadsyahrul.submissionjetpackpro.databinding.FragmentMoviesBinding
import com.ziadsyahrul.submissionjetpackpro.viewModel.ViewModelFactory


class MoviesFragment : Fragment() {

    private lateinit var binding: FragmentMoviesBinding

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

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
            val movAdapter = MovieAdapter()

            viewModel.getMoviess().observe(viewLifecycleOwner, Observer{ listMovie ->
                movAdapter.submitList(listMovie.data)
                movAdapter.notifyDataSetChanged()
            })

            with(binding.rvMovie){
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movAdapter
            }

        }
    }



}