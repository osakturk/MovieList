package com.example.moviecase.di.module

import okhttp3.Interceptor
import okhttp3.Response

class Interceptor: Interceptor {

    /**
     * Interceptor class for setting of the headers for every request
     */
    override fun intercept(chain: Interceptor.Chain): Response {

        val original = chain.request()
        // Request customization: add request headers
        val requestBuilder = original.newBuilder()

        requestBuilder.addHeader("api_key",
            "35ef0461fc4557cf1d256d3335ed7545"
        )
        requestBuilder.addHeader("language", "tr-TR")
        requestBuilder.addHeader("query","test")
        val request = requestBuilder.build()
        return chain.proceed(request)
    }

}