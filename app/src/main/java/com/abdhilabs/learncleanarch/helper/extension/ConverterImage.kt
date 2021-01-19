package com.abdhilabs.learncleanarch.helper.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

fun ImageView.setUrlToImages(src: String?) =
    Glide.with(this)
        .load(src)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)