package com.example.moviecase.ui.movie

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.moviecase.R
import com.example.moviecase.base.BaseFragment
import com.example.moviecase.databinding.MovieListFragmentBinding
import com.example.moviecase.interfaces.IMovie
import com.example.moviecase.model.Movie
import com.example.moviecase.ui.adapter.MovieAdapter


class MovieListFragment: BaseFragment<MovieListViewModel, MovieListFragmentBinding>() {
    override val getLayoutId: Int = R.layout.movie_list_fragment
    override val viewModelClass: Class<MovieListViewModel> = MovieListViewModel::class.java

    private val movieList: ArrayList<Movie> = arrayListOf()

    private val movieAdapter = MovieAdapter(movieList, object : IMovie{
        override fun onMovieSelected(movieId: Int) {
            val bundle = Bundle()
            bundle.putInt("id",movieId)
            view?.let { Navigation.findNavController(it).navigate(R.id.action_repo_to_repo2,bundle) }

        }
    })

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
        init()
        initRecycler()
        observe()
    }

    private fun init() {
        //viewModel.getMovieList()
    }

    private fun initRecycler() {
        binding.movieRecycler.adapter = movieAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.filter_menu, menu)
    }

    private fun observe() {
        binding.searchTextView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isNullOrEmpty().not() && newText.length > 2){
                    viewModel.getMovieList(newText)
                }
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

        })

        viewModel.data.observe(this, Observer { data ->
            movieList.clear()
            movieList.addAll(data)
            movieAdapter.notifyDataSetChanged()
        })
    }
}