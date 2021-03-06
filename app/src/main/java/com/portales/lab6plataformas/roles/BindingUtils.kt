package com.portales.lab6plataformas.roles

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.portales.lab6plataformas.R


@BindingAdapter("typeImage")
fun ImageView.setTypeImage(index: Int?) {
    index?.let {
        setImageResource(when (index) {
            1 -> R.drawable.camera_film
            2 -> R.drawable.chart
            3 -> R.drawable.starbucks
            else -> R.drawable.logo
        })
    }
}