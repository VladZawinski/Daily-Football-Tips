package com.escatatic.shahadtips.bindingadapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import com.escatatic.shahadtips.R
import com.escatatic.shahadtips.base.BetStatus
import com.escatatic.shahadtips.domain.models.Goals

@BindingAdapter("bindResultStatus")
fun bindResultStatus(imageView: ImageView,status: String){
    when(status){
        BetStatus.WIN -> {
            imageView.load(R.drawable.ic_checkbox_marked_circle)
        }

        BetStatus.LOSE -> {
            imageView.load(R.drawable.ic_close_circle)
        }

        BetStatus.PENDING -> {
            imageView.load(R.drawable.ic_clock_time_four)
        }
    }
}

@BindingAdapter("bindGoals")
fun bindGoals(textView: TextView,goals: Goals){
    textView.text = if (goals.home == 1080 || goals.away == 1080){
        " - "
    }else {
        "${goals.home} - ${goals.away}"
    }
}