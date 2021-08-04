package com.example.moviecase.ui.moviedetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moviecase.base.BaseViewModel
import com.example.moviecase.model.MovieDetailEntity
import com.example.moviecase.service.helper.DataHolder
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(private val repoRepository: MovieDetailRepository) :
    BaseViewModel() {

    val data: MutableLiveData<MovieDetailEntity> = MutableLiveData()
    fun getMovieDetail(id: Int){
        viewModelScope.launch {
            val response = repoRepository.getMovieDetail(this@MovieDetailViewModel, id)

            response.let {
                if (it is DataHolder.Success){
                    data.postValue(it.body)
                }
            }
        }
    }

}