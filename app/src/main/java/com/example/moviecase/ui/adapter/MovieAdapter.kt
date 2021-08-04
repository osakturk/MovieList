package com.example.moviecase.ui.adapter

import com.example.moviecase.R
import com.example.moviecase.binding.DataBoundAdapter
import com.example.moviecase.binding.DataBoundViewHolder
import com.example.moviecase.databinding.ItemMovieBinding
import com.example.moviecase.interfaces.IMovie
import com.example.moviecase.model.Movie

class MovieAdapter(private val movieList:ArrayList<Movie>, private val movieInterface: IMovie):
    DataBoundAdapter<ItemMovieBinding>(R.layout.item_movie) {
    override fun bindItem(
        holder: DataBoundViewHolder<ItemMovieBinding>,
        position: Int,
        payloads: List<Any>
    ) {
        holder.binding.data = movieList[position]
        holder.binding.callback = movieInterface

    }


    override fun getItemCount(): Int {
        return movieList.size
    }
}