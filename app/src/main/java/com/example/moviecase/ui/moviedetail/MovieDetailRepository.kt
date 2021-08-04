package com.example.moviecase.ui.moviedetail

import com.example.moviecase.model.MovieDetailEntity
import com.example.moviecase.service.ApiService
import com.example.moviecase.service.INetworkResponseHandling
import com.example.moviecase.service.helper.DataHolder
import com.example.moviecase.service.helper.RequestHelper
import javax.inject.Inject

class MovieDetailRepository @Inject constructor(
    private val apiService: ApiService
){
    suspend fun getMovieDetail(iNetworkResponseHandling: INetworkResponseHandling, id:Int): DataHolder<MovieDetailEntity>? {
        return object : RequestHelper<MovieDetailEntity>() {
            override suspend fun createNetworkRequest(): MovieDetailEntity {
                return apiService.getMovieDetail(id,"35ef0461fc4557cf1d256d3335ed7545")
            }

        }.loadRequest(iNetworkResponseHandling, true)
    }
}