package com.sitare.movierecyclerview

import android.graphics.Movie
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sitare.movierecyclerview.databinding.FragmentMoviesBinding

class MoviesFragment : Fragment() {
    private lateinit var binding: FragmentMoviesBinding
    private lateinit var moviesList : ArrayList<Movies>
    private lateinit var adapter: MoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_movies, container, false )
        binding.movieRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        val m1 = Movies(1, "Bir Zamanlar Anadoluda", "anadoluda", 2013, 13.99, "Dram", "Nuri Bilge Ceylan")
        val m2 = Movies(2, "Django", "django", 2014, 14.99, "Aksiyon", "Quentin Tarantino")
        val m3 = Movies(3, "Inception", "inception", 2015, 15.99, "Bilim Kurgu", "Christopher Nolan")
        val m4 = Movies(4, "Interstellar", "interstellar", 2012, 11.99, "Bilim Kurgu", "Christopher Nolan")
        val m5 = Movies(5, "The Hateful Eight", "thehatefuleight", 2010, 10.99, "Dram", "Quentin Tarantino")
        val m6 = Movies(5, "The Pianist", "thepianist", 2010, 10.99, "Dram", "Roman Polansky")

        moviesList = ArrayList()
        moviesList.add(m1)
        moviesList.add(m2)
        moviesList.add(m3)
        moviesList.add(m4)
        moviesList.add(m5)
        moviesList.add(m6)

        adapter = MoviesAdapter(requireContext(), moviesList)
        binding.movieRecyclerView.adapter = adapter

        return binding.root
    }
}