package com.fongfuse.friendsapp.presentation.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.BlurTransformation
import java.util.Date

@BindingAdapter("setImageUrl")
fun ImageView.setImage(imageUrl: String?) {
    load(imageUrl)
}

@BindingAdapter("setBlurImageUrl")
fun ImageView.setBlurImageUrl(imageUrl: String?) {
    load(imageUrl) {
        transformations(BlurTransformation(context, 20.0f))
    }
}

@BindingAdapter(value = ["setYearAndEpisodes_date", "setYearAndEpisodes_episodes"])
fun TextView.setYearAndEpisodes(date: Date?, countOfEpisodes: Int?) {
    if (date != null && countOfEpisodes != null) {
        text = String.format("%d | %s Episodes", (1900 + date.year), countOfEpisodes)
    }
}
