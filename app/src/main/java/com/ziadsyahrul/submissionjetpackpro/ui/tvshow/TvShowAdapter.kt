package com.ziadsyahrul.submissionjetpackpro.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ziadsyahrul.submissionjetpackpro.data.local.MovieModel
import com.ziadsyahrul.submissionjetpackpro.data.local.TvShowModel
import com.ziadsyahrul.submissionjetpackpro.databinding.ItemListBinding
import com.ziadsyahrul.submissionjetpackpro.ui.detail.DetailActivity
import com.ziadsyahrul.submissionjetpackpro.ui.detail.DetailViewModel

class TvShowAdapter: RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {

    private val tvShow =  ArrayList<TvShowModel>()

    fun setTvShow(tvShow: List<TvShowModel>){
        if (tvShow.isNullOrEmpty()) return
        this.tvShow.clear()
        this.tvShow.addAll(tvShow)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(tvShow[position])
    }

    override fun getItemCount(): Int = tvShow.size

    class TvShowViewHolder(private val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowModel){
            with(binding){
                tvItemTitle.text = tvShow.name
                year.text = tvShow.releaseDate
                Picasso.get().load("https://image.tmdb.org/t/p/w500/" + tvShow.posterPath).into(imgPoster)

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_FILM, tvShow.id)
                    intent.putExtra(DetailActivity.EXTRA_CATEGORY, DetailViewModel.TV_SHOW)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}