package com.example.moviecase.service.helper

sealed class DataHolder<out T> {

    data class Success<T>(
        val body: T
    ) : DataHolder<T>()

    data class SuccessWithMessage<T>(
        val body: T,
        val popUp: GenericNetworkPopUp
    ) : DataHolder<T>()

    class Empty<T> : DataHolder<T>()

    data class Error<T>(val errorMessage: String) : DataHolder<T>()

    data class ErrorWithMessage<T>(val popUp: GenericNetworkPopUp) : DataHolder<T>()
}