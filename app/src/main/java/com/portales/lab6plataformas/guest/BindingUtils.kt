package com.portales.lab6plataformas.guest

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.portales.lab6plataformas.R


@BindingAdapter("typeImage")
fun ImageView.setTypeImage(index: Int?) {
    index?.let {
        setImageResource(when (index) {
            1 -> R.drawable.camara_film
            2 -> R.drawable.chart
            3 -> R.drawable.jamboard
            else -> R.drawable.logo
        })
    }
}
