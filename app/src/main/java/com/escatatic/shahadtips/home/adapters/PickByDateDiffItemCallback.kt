package com.escatatic.shahadtips.home.adapters

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.escatatic.shahadtips.domain.models.PicksByTipster

@SuppressLint("Unused")
object PickByDateDiffItemCallback: DiffUtil.ItemCallback<PicksByTipster>() {
    override fun areItemsTheSame(oldItem: PicksByTipster, newItem: PicksByTipster): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: PicksByTipster, newItem: PicksByTipster): Boolean {
        return oldItem.data == newItem.data
    }
}