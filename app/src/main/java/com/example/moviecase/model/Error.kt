package com.example.moviecase.model


import com.google.gson.annotations.SerializedName

data class Error(
    @SerializedName("message")
    val message: Any,
    @SerializedName("returnUrl")
    val returnUrl: Any,
    @SerializedName("title")
    val title: Any,
    @SerializedName("type")
    val type: Int
)