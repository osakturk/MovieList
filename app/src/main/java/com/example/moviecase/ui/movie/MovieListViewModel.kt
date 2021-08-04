package com.example.moviecase.ui.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moviecase.base.BaseViewModel
import com.example.moviecase.model.Movie
import com.example.moviecase.service.helper.DataHolder
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieListViewModel@Inject constructor(private val repoRepository: MovieListRepository) :
    BaseViewModel(){

    val data: MutableLiveData<List<Movie>> = MutableLiveData()
    fun getMovieList(queryText: String? = null){
        viewModelScope.launch {
            val response = repoRepository.getMovieList(this@MovieListViewModel, queryText)

            response.let {
                if (it is DataHolder.Success){
                    data.postValue(it.body.results)
                }
            }
        }
    }
}