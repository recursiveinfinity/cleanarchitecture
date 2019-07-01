package com.cleanarchitecture.presentation.common.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View =
        LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, imageUrl: String) {
    Picasso.get().load(imageUrl).into(imageView)
}