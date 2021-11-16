package com.android.example.demomvvm.core.util

import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.android.example.demomvvm.R
import com.android.example.demomvvm.core.base.BaseRecyclerViewAdapter
import com.bumptech.glide.Glide
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.*


@BindingAdapter("avatarImage")
fun ImageView.fetchImage(src: String?) {
    if (src != null) {
        val uri = src.toUri().buildUpon().scheme("https").build()
        Glide.with(context)
            .load(uri)
            .circleCrop()
            .placeholder(R.drawable.ic_profile)
            .error(R.drawable.ic_profile)
            .into(this)
    } else {
        setImageResource(R.drawable.ic_profile)
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


/**
 * Use binding adapter to set the recycler view data using livedata object
 */
@Suppress("UNCHECKED_CAST")
@BindingAdapter("android:liveData")
fun <T> setRecyclerViewData(recyclerView: RecyclerView, items: LiveData<List<T>>?) {
    items?.value?.let { itemList ->
        (recyclerView.adapter as? BaseRecyclerViewAdapter<T>)?.apply {
            clear()
            addData(itemList)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@BindingAdapter("dateText")
fun TextView.bindUpdatedAtDateText(dateString: String?) {
    text = if (dateString == null) {
        ""
    } else {
        val dtf = DateTimeFormatter.ofPattern(" dd-MMM-uuuu", Locale.ENGLISH)
        dtf.format(OffsetDateTime.parse(dateString))
    }
}


