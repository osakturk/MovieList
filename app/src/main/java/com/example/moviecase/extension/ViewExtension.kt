package com.example.moviecase.extension

import android.view.View
import kotlin.math.abs

fun View.disableClickTemporarily(delayMillis: Long = 500) {
    isClickable = false
    postDelayed({
        isClickable = true
    }, if(delayMillis == 0L) 500L else abs(delayMillis))
}