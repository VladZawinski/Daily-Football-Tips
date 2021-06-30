package com.escatatic.shahadtips.home.adapters

import androidx.recyclerview.widget.DiffUtil
import com.escatatic.shahadtips.domain.models.Pick

object PicksDiffItemCallback: DiffUtil.ItemCallback<Pick>() {
    override fun areItemsTheSame(oldItem: Pick, newItem: Pick): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Pick, newItem: Pick): Boolean {
        return oldItem.goals == newItem.goals
    }
}