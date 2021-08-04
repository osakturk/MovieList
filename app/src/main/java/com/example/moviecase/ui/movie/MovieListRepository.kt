package com.example.moviecase.ui.movie

import com.example.moviecase.model.MovieListEntity
import com.example.moviecase.service.ApiService
import com.example.moviecase.service.INetworkResponseHandling
import com.example.moviecase.service.helper.DataHolder
import com.example.moviecase.service.helper.RequestHelper
import javax.inject.Inject

class MovieListRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getMovieList(iNetworkResponseHandling: INetworkResponseHandling, queryText: String? = null): DataHolder<MovieListEntity>? {
        return object : RequestHelper<MovieListEntity>() {
            override suspend fun createNetworkRequest(): MovieListEntity {
                return apiService.getMovieList("35ef0461fc4557cf1d256d3335ed7545",queryText)
            }

        }.loadRequest(iNetworkResponseHandling, true)
    }
}