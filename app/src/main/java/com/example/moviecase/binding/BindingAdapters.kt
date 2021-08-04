package com.example.moviecase.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.moviecase.BuildConfig
import com.squareup.picasso.Picasso

object BindingAdapters {
    @JvmStatic
    @BindingAdapter(value = ["loadImage"], requireAll = false)
    fun loadImage(view: ImageView, url: String?) {
        url?.let {
            Picasso.get().load(BuildConfig.BASE_URL + it.replace("/","")).into(view)
        }
    }

}
