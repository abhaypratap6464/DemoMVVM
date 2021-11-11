package com.android.example.demomvvm.core.util

import android.view.View
import androidx.databinding.BindingAdapter


@BindingAdapter("visible")
fun View.bindContentVisibility(content: String?) {
    visibility = if (content.isNullOrEmpty()) {
        View.GONE
    } else {
        View.VISIBLE
    }
}

@BindingAdapter("fadeVisible")
fun View.bindFadeVisible(visible: Boolean? = true) {
    if (tag == null) {
        tag = true
        visibility = if (visible == true) View.VISIBLE else View.GONE
    } else {
        animate().cancel()
        if (visible == true) {
            if (visibility == View.GONE)
                fadeIn()
        } else {
            if (visibility == View.VISIBLE)
                fadeOut()
        }
    }
}
