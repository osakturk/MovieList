package com.example.moviecase.service

interface INetworkResponseHandling {
    fun loading(switch: Boolean)
    fun onGenericErrorTaken(message: String)
    fun onErrorPopUp(header: String, body: String)
}