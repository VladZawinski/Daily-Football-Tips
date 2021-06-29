package com.escatatic.shahadtips.home.adapters

import androidx.recyclerview.widget.DiffUtil
import com.escatatic.shahadtips.domain.models.PicksByDate

object PickByDateDiffItemCallback: DiffUtil.ItemCallback<PicksByDate>() {
    override fun areItemsTheSame(oldItem: PicksByDate, newItem: PicksByDate): Boolean {
        return oldItem.date == newItem.date
    }

    override fun areContentsTheSame(oldItem: PicksByDate, newItem: PicksByDate): Boolean {
        return oldItem.data == newItem.data
    }
}