package com.example.moviecase.service

import com.example.moviecase.model.MovieDetailEntity
import com.example.moviecase.model.MovieListEntity
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("search/movie")
    suspend fun getMovieList(
        @Query(
            value = "api_key",
            encoded = true
        ) apiKey: String,
        @Query(
            value = "query",
            encoded = true
        ) query: String? = null,
        @Query(
            value = "language",
            encoded = true
        ) language: String? = "en-US",
        @Query(
            value = "page",
            encoded = true
        ) page: Int? = 1,
        @Query(
            value = "include_adult",
            encoded = true
        ) includeAdult: Boolean? = false
    ): MovieListEntity

    @GET("movie/{id}")
    suspend fun getMovieDetail(
        @Path("id") id: Int,
        @Query(
            value = "api_key",
            encoded = true
        ) apiKey: String
    ): MovieDetailEntity

}