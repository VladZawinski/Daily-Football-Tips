package com.escatatic.shahadtips.home.match

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.escatatic.shahadtips.R
import com.escatatic.shahadtips.base.DataBindingFragment
import com.escatatic.shahadtips.databinding.FragmentMatchBinding
import com.escatatic.shahadtips.home.HomeFragment
import com.escatatic.shahadtips.home.adapters.PickByDateDiffItemCallback
import com.escatatic.shahadtips.home.adapters.PicksDiffItemCallback
import com.escatatic.shahadtips.home.adapters.homeAdapterDelegate
import com.escatatic.shahadtips.home.adapters.pickAdapterDelegate
import com.escatatic.shahadtips.home.bottomsheet.HomeBottomSheetFragment
import com.escatatic.shahadtips.home.uimodel.HomeViewEffect
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import io.uniflow.android.livedata.onEvents
import io.uniflow.android.livedata.onStates
import timber.log.Timber

class MatchFragment(
    override val layoutRes: Int = R.layout.fragment_match
) : DataBindingFragment<FragmentMatchBinding>(){

    private val viewModel by viewModels<MatchViewModel>()

    private val delegate = AsyncListDifferDelegationAdapter(
        PicksDiffItemCallback,
        pickAdapterDelegate {
//            val bottomSheet = HomeBottomSheetFragment.newInstance(
//                onMarkAsWin = {
//                    viewModel.markAsWin(it.id)
//                },
//                onMarkAsLose = {
//                    viewModel.markAsLose(it.id)
//                },
//                onSearchOnBrowser = {
//
//                },
//                onUpdateScore = { home,away ->
//                    viewModel.updateGoals(home,away,it.id)
//                }
//            )
//            bottomSheet.show(requireFragmentManager(), MatchFragment::class.java.toString())
        }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.also {
            Timber.d("${it.getString("date")}")
            viewModel.fetchByDate(it.getString("date")!!)
        }

        viewBinding.picksRV.apply {
            adapter = delegate
        }

        viewBinding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.refresh()
        }

        onStates(viewModel){
            when(it){
                is MatchViewState -> {
                    viewBinding.swipeRefreshLayout.isRefreshing = false
                    delegate.items = (it as MatchViewState).picks
                }
            }
        }

        onEvents(viewModel){
            when(it){
                is MatchViewEvent.Updated -> {
                    showSnackBar("Updated successfully!",viewBinding.root)
                }

                is MatchViewEvent.MarkedSuccessfully -> {
                    showSnackBar("Marked successfully!",viewBinding.root)
                }

                is MatchViewEvent.Failed -> {
                    showSnackBar("Something went wrong!",viewBinding.root)
                }

                is  MatchViewEvent.Refreshing -> {

                }

                is MatchViewEvent.Loading -> {

                }
            }
        }

    }

    companion object {
        fun newInstance(date: String) = MatchFragment().apply {
            val bundle = Bundle().apply {
                putString("date",date)
            }
            arguments = bundle
        }
    }

}