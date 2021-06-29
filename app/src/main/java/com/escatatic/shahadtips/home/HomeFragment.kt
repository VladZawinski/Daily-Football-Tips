package com.escatatic.shahadtips.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.escatatic.shahadtips.R
import com.escatatic.shahadtips.base.DataBindingFragment
import com.escatatic.shahadtips.databinding.FragmentHomeBinding
import com.escatatic.shahadtips.home.adapters.PickByDateDiffItemCallback
import com.escatatic.shahadtips.home.adapters.homeAdapterDelegate
import com.escatatic.shahadtips.home.bottomsheet.HomeBottomSheetFragment
import com.escatatic.shahadtips.home.uimodel.HomeViewEffect
import com.escatatic.shahadtips.home.uimodel.HomeViewState
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import io.uniflow.android.livedata.onEvents
import io.uniflow.android.livedata.onStates


class HomeFragment(
    override val layoutRes: Int = R.layout.fragment_home
) : DataBindingFragment<FragmentHomeBinding>(){

    private val viewModel by viewModels<HomeViewModel>()

    private val delegate = AsyncListDifferDelegationAdapter(
        PickByDateDiffItemCallback,
        homeAdapterDelegate {
            val bottomSheet = HomeBottomSheetFragment.newInstance(
                onMarkAsWin = {
                    viewModel.markAsWin(it.id)
                },
                onMarkAsLose = {
                    viewModel.markAsLose(it.id)
                },
                onSearchOnBrowser = {

                },
                onUpdateScore = { home,away ->
                    viewModel.updateGoals(home,away,it.id)
                }
            )
            bottomSheet.show(requireFragmentManager(),HomeFragment::class.java.toString())
        }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.picksRV.apply {
            adapter = delegate
        }

        viewBinding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.fetchForTheFirstTime()
        }

        onStates(viewModel){
            when(it){
                is HomeViewState -> {
                    viewBinding.swipeRefreshLayout.isRefreshing = false
                    delegate.items = it.picks
                }
            }
        }

        onEvents(viewModel){
            when(it){
                is HomeViewEffect.Updated -> {
                    showSnackBar("Updated successfully!",viewBinding.root)
                }

                is HomeViewEffect.MarkedSuccessfully -> {
                    showSnackBar("Marked successfully!",viewBinding.root)
                }

                is HomeViewEffect.Failed -> {
                    showSnackBar("Something went wrong!",viewBinding.root)
                }
            }
        }
    }
}