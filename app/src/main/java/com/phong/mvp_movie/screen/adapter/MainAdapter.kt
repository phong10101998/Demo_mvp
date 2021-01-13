package com.phong.mvp_movie.screen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.phong.mvp_movie.R
import com.phong.mvp_movie.data.model.Movie
import com.phong.mvp_movie.util.Constant
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie_grid.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    private val movie = mutableListOf<Movie>()

    fun updateData(movies: MutableList<Movie>?) {
        movies?.let {
            this.movie.clear()
            this.movie.addAll(movies)
            this.notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_grid, parent, false)
        return DataViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.binData(movie[position])
    }

    override fun getItemCount()= movie.size

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun binData(movie: Movie) {
            itemView.textTitle.text = movie.title
            itemView.textVoteCount.text = movie.voteCount.toString()
            Picasso.get().load(Constant.IMAGE_URL + movie.posterUrl).into(itemView.imgPoster)
        }
    }
}
