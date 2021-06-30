package com.escatatic.shahadtips.home.adapters

import android.animation.Animator
import android.annotation.SuppressLint
import android.view.View
import android.view.animation.Animation
import androidx.databinding.DataBindingUtil
import com.escatatic.shahadtips.R
import com.escatatic.shahadtips.databinding.ViewholderPickBinding
import com.escatatic.shahadtips.databinding.ViewholderPickByDateBinding
import com.escatatic.shahadtips.domain.models.Pick
import com.escatatic.shahadtips.domain.models.PicksByDate
import com.escatatic.shahadtips.utils.SimpleAnimatorListener
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

@SuppressLint("Unused")
fun homeAdapterDelegate(
    onMatchClick: (Pick) -> Unit
) = adapterDelegateViewBinding<PicksByDate, PicksByDate,ViewholderPickByDateBinding>(
    { layoutInflater, parent -> DataBindingUtil.inflate(layoutInflater,
        R.layout.viewholder_pick_by_date,parent,false) }
){
    bind {
        binding.dateTextView.text = item.date

        binding.collapseDetectView.setOnLongClickListener {
            binding.pickRV.animate()
                .alpha(0f)
                .setListener(object: SimpleAnimatorListener() {
                    override fun onAnimationEnd(animation: Animator?) {
                        super.onAnimationEnd(animation)
                        binding.pickRV.apply {
                            visibility = View.GONE
                            alpha = 1f
                            translationY = 0f
                        }
                    }
                })

            true
        }

        binding.collapseDetectView.setOnClickListener {
            binding.pickRV.visibility = View.VISIBLE
        }

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