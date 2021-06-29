package com.escatatic.shahadtips.home.adapters

import androidx.databinding.DataBindingUtil
import com.escatatic.shahadtips.R
import com.escatatic.shahadtips.databinding.ViewholderPickBinding
import com.escatatic.shahadtips.databinding.ViewholderPickByDateBinding
import com.escatatic.shahadtips.domain.models.Pick
import com.escatatic.shahadtips.domain.models.PicksByDate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

fun homeAdapterDelegate(
    onMatchClick: (Pick) -> Unit
) = adapterDelegateViewBinding<PicksByDate, PicksByDate,ViewholderPickByDateBinding>(
    { layoutInflater, parent -> DataBindingUtil.inflate(layoutInflater,
        R.layout.viewholder_pick_by_date,parent,false) }
){
    bind {
        binding.dateTextView.text = item.date
        binding.pickRV.apply {
            adapter = ListDelegationAdapter(
                pickAdapterDelegate(onMatchClick)
            ).also {
                it.items = item.data
            }
        }
    }
}

fun pickAdapterDelegate(
    onMatchClick: (Pick) -> Unit
) = adapterDelegateViewBinding<Pick, Pick,ViewholderPickBinding>(
    { layoutInflater, parent -> DataBindingUtil.inflate(layoutInflater,
        R.layout.viewholder_pick,parent,false) }
){
    bind {
        binding.pick = item
        binding.root.setOnClickListener { onMatchClick(item) }
    }
}