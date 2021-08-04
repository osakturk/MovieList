package com.example.moviecase.ui.movie

import android.app.Activity
import android.view.View
import android.widget.ImageButton
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviecase.MainActivity
import com.example.moviecase.base.BaseViewModel
import com.example.moviecase.model.Movie
import com.example.moviecase.model.MovieListEntity
import com.example.moviecase.service.helper.DataHolder
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieListViewModel@Inject constructor(private val repoRepository: MovieListRepository) :
    BaseViewModel(){

    val data: MutableLiveData<List<Movie>> = MutableLiveData()
    var movieList = ArrayList<Movie>()
    fun getMovieList(queryText: String? = null, language: String? = null, page:Int? = null, adult: Boolean? = null){
        viewModelScope.launch {
            val response = repoRepository.getMovieList(this@MovieListViewModel, queryText, language, page, adult)

            response.let {
                if (it is DataHolder.Success){
                    allMovieListAdd(it)
                    data.postValue(movieList)
                    MovieListFragment.isSlided = false
                }
            }
        }
    }

    fun onScrollListener(recyclerProduct: RecyclerView, goToTop: ImageButton) {
        recyclerProduct.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0 || dy < 0 && goToTop.isShown) {
                    goToTop.visibility = View.VISIBLE
                }
                if ((recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition() == 0) {
                    goToTop.visibility = View.INVISIBLE
                }
            }
        })
    }

    fun backToTop(recycler: RecyclerView, goToTop: ImageButton) {
        recycler.smoothScrollToPosition(0)
        goToTop.visibility = View.GONE
    }

    private fun allMovieListAdd(baseMoviesEntity: DataHolder.Success<MovieListEntity>) {
        baseMoviesEntity.body.results.let {
            for (movieItem in it) {
                movieList.add(movieItem)
            }
        }

    }
}