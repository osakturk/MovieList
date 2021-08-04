package com.example.moviecase.model

import com.google.gson.annotations.SerializedName

data class MovieListEntity(
    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val results: List<Movie>,

    @SerializedName("total_pages")
    val total_pages: Int?,

    @SerializedName("total_results")
    val total_results: Int?
)