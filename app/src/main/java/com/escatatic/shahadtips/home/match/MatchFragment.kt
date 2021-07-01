package com.escatatic.shahadtips.home.match

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private val delegate = AsyncListDifferDelegationAdapter(
        PickByDateDiffItemCallback,
        homeAdapterDelegate(
            onMatchClick = { pick ->
                val bottomSheet = HomeBottomSheetFragment.newInstance(
                    onMarkAsWin = {
                        viewModel.markAsWin(pick.id)
                    },
                    onMarkAsLose = {
                        viewModel.markAsLose(pick.id)
                    },
                    onSearchOnBrowser = {
                        val query = "${pick.match.home} vs ${pick.match.away} sofascore"
                        val url = "https://www.google.com/search?q=$query"
                        startActivity(Intent(Intent.ACTION_VIEW,Uri.parse(url)))
                    },
                    onUpdateScore = { home,away ->
                        viewModel.updateGoals(home,away,pick.id)
                    },
                    markAs = {
                        viewModel.addBadge(pick.id,it)
                    }
                )
                bottomSheet.show(requireFragmentManager(), MatchFragment::class.java.toString())
            },
            onLongClick = { pick,view ->
                registerForContextMenu(view)
                requireActivity().openContextMenu(view)
                Timber.d("$pick")
            }
        )
    )

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        requireActivity().menuInflater.inflate(R.menu.markas_menu,menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.favorite -> {
                return true
            }

            R.id.sure -> {
                return true
            }

            R.id.risky -> {
                return true
            }

            R.id.ordinary -> {
                return true
            }

        }
        return super.onContextItemSelected(item)
    }

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