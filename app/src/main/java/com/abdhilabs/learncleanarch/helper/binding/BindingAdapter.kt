package com.abdhilabs.learncleanarch.helper.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.abdhilabs.learncleanarch.helper.extension.setUrlToImages

@BindingAdapter("setImgFromUrl")
fun ImageView.setImgFromUrl(url: String?) {
    if (url == null) return
    setUrlToImages(url)
}