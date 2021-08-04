package com.example.moviecase.ui.movie

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviecase.R
import com.example.moviecase.base.BaseFragment
import com.example.moviecase.databinding.MovieListFragmentBinding
import com.example.moviecase.extension.disableClickTemporarily
import com.example.moviecase.interfaces.IMovie
import com.example.moviecase.model.Movie
import com.example.moviecase.ui.adapter.MovieAdapter
import kotlinx.android.synthetic.main.movie_list_fragment.*


class MovieListFragment : BaseFragment<MovieListViewModel, MovieListFragmentBinding>() {
    override val getLayoutId: Int = R.layout.movie_list_fragment
    override val viewModelClass: Class<MovieListViewModel> = MovieListViewModel::class.java

    private val movieList: ArrayList<Movie> = arrayListOf()
    private var endlessScrollListener: EndlessGridRecyclerOnScrollListener? = null
    private var searchText: String? = ""
    private var page: Int = 1


    private val movieAdapter = MovieAdapter(movieList, object : IMovie {
        override fun onMovieSelected(movieId: Int) {
            val bundle = Bundle()
            bundle.putInt("id", movieId)
            view?.let {
                Navigation.findNavController(it).navigate(R.id.action_repo_to_repo2, bundle)
            }

        }
    })

    companion object {
        var isSlided = false
        var isListing = false
    }

    private var isFirstRequest = true

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
        init()
        initRecycler()
        observe()
    }

    private fun init() {
        viewModel.onScrollListener(movieRecycler, goToTop)
        binding.goToTop.setOnClickListener {
            viewModel.backToTop(movieRecycler, binding.goToTop)
            it.disableClickTemporarily(1000)

        }
    }

    private fun initRecycler() {
        binding.movieRecycler.adapter = movieAdapter
        endlessScrollListener = object :
            EndlessGridRecyclerOnScrollListener(binding.movieRecycler.layoutManager as GridLayoutManager) {
            override fun onLoadMore() {
                if ( !isSlided && movieList.size > 19) {
                    page++
                    isSlided = true
                    loadMoreProducts()
                }

                //Bu if bloğu, onLoadMore'un kendi kendine ilk servis çağrısında tekrardan ürün listesi
                //servisini gereksiz yere çağrılmaması içindir.
                if (isFirstRequest && !isSlided && movieList.size > 19) {
                    isFirstRequest = false
                    endlessScrollListener?.reset()
                }
            }
        }
        // Adds the scroll listener to RecyclerView
        // Adds the scroll listener to RecyclerView
        binding.movieRecycler.addOnScrollListener(endlessScrollListener as EndlessGridRecyclerOnScrollListener)


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.filter_menu, menu)
    }

    private fun observe() {
        binding.searchTextView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isEmpty().not() && newText.length > 2) {
                    viewModel.movieList = arrayListOf()
                    viewModel.getMovieList(newText, page = page)
                    searchText = newText
                    isListing = true
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

    private fun loadMoreProducts() {
        viewModel.getMovieList(searchText, page = page)
    }
}