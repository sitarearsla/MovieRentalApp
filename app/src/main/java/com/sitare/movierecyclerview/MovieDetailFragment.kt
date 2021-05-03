package com.sitare.movierecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.sitare.movierecyclerview.databinding.FragmentMovieDetailBinding

class MovieDetailFragment : Fragment() {
    private lateinit var binding: FragmentMovieDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movie_detail, container, false)

        val bundle : MovieDetailFragmentArgs by navArgs()
        val incomingMovie = bundle.movie

        binding.nameTextView.text = incomingMovie.name
        binding.yearTextView.text = incomingMovie.year.toString()
        binding.categoryTextView.text = incomingMovie.category
        binding.directorTextView.text = incomingMovie.director
        binding.movieImageView.setImageResource(resources.getIdentifier(incomingMovie.png_name,
            "drawable", requireContext().packageName))
        return binding.root
    }
}