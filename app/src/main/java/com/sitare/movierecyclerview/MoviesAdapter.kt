package com.sitare.movierecyclerview

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.sitare.movierecyclerview.databinding.MovieCardBinding

class MoviesAdapter(var mContext: Context, var moviesList: List<Movies>) : RecyclerView.Adapter<MoviesAdapter.MovieCardHolder>() {
    inner class MovieCardHolder(movieCardBinding: MovieCardBinding)
        :RecyclerView.ViewHolder(movieCardBinding.root) {
            var design:MovieCardBinding

            init {
                this.design = movieCardBinding
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCardHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = MovieCardBinding.inflate(layoutInflater, parent, false)
        return MovieCardHolder(design)
    }

    override fun onBindViewHolder(holder: MovieCardHolder, position: Int) {
        val movie = moviesList.get(position)

        holder.design.imageViewFilm.setImageResource(
            mContext.resources.getIdentifier(
                movie.png_name, "drawable", mContext.packageName
            ))
        holder.design.textViewFilmAdi.text = movie.name
        holder.design.textViewFiyat.text = "${movie.price} \u20BA"
        holder.design.buttonSepet.setOnClickListener {
            Snackbar.make(it, "${movie.name} added to cart", Snackbar.LENGTH_SHORT).show()
        }

        holder.design.filmCardview.setOnClickListener {
            val action = MoviesFragmentDirections.toDetailFragment(movie)
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}