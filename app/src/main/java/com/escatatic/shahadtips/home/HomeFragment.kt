package com.escatatic.shahadtips.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.escatatic.shahadtips.R
import com.escatatic.shahadtips.base.DataBindingFragment
import com.escatatic.shahadtips.databinding.FragmentHomeBinding
import com.escatatic.shahadtips.domain.models.MatchDate
import com.escatatic.shahadtips.home.adapters.HomePagerAdapter
import com.escatatic.shahadtips.home.adapters.PickByDateDiffItemCallback
import com.escatatic.shahadtips.home.adapters.homeAdapterDelegate
import com.escatatic.shahadtips.home.bottomsheet.HomeBottomSheetFragment
import com.escatatic.shahadtips.home.uimodel.HomeViewEffect
import com.escatatic.shahadtips.home.uimodel.HomeViewState
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import io.uniflow.android.livedata.onEvents
import io.uniflow.android.livedata.onStates
import timber.log.Timber


class HomeFragment(
    override val layoutRes: Int = R.layout.fragment_home
) : DataBindingFragment<FragmentHomeBinding>(){

    private val viewModel by viewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.materialToolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.addMatch -> {
                    findNavController().navigate(R.id.action_homeFragment_to_addMatchFragment)
                    false
                }
            }

            true
        }

        onStates(viewModel){
            when(it){
                is HomeViewState -> {
                        Timber.d("${it.dates}")
                    if (it.dates.isNotEmpty()){
                        setUpPager(it.dates)
                    }
                }
            }
        }

    }

    private fun setUpPager(dates: List<MatchDate>){
        viewBinding.matchDatePager.adapter = HomePagerAdapter(requireFragmentManager(),dates)
        viewBinding.tabLayout.setupWithViewPager(viewBinding.matchDatePager)
    }
}