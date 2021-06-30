package com.escatatic.shahadtips.addmatch

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.escatatic.shahadtips.R
import com.escatatic.shahadtips.base.DataBindingFragment
import com.escatatic.shahadtips.databinding.FragmentAddMatchBinding
import com.escatatic.shahadtips.extensions.addBackButtonIfToolbarExists
import io.uniflow.android.livedata.onEvents
import io.uniflow.android.livedata.onStates

class AddMatchFragment(
    override val layoutRes: Int = R.layout.fragment_add_match
) : DataBindingFragment<FragmentAddMatchBinding>(){

    private val viewModel by viewModels<AddMatchViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addBackButtonIfToolbarExists(viewBinding.addMatchToolbar)

        viewBinding.uploadBtn.setOnClickListener {
            val home = viewBinding.homeEditText.text.toString().trim()
            val away = viewBinding.awayEditText.text.toString().trim()
            val tip = viewBinding.tipEditText.text.toString().trim()
            val tipBy = viewBinding.tipByEditText.text.toString().trim()


            if (home.isNotEmpty() && away.isNotEmpty() && tip.isNotEmpty() && tipBy.isNotEmpty()){
                viewModel.addMatch(home, away, tip, tipBy)
            }

        }

        onEvents(viewModel){
            when(it) {
                is AddMatchViewEvent.Uploading -> {

                }

                is AddMatchViewEvent.Success -> {
                    viewBinding.awayEditText.text?.clear()
                    viewBinding.homeEditText.text?.clear()
                    viewBinding.tipByEditText.text?.clear()
                    viewBinding.tipEditText.text?.clear()
                }

                is AddMatchViewEvent.Error -> {
                    showSnackBar(it.message,viewBinding.root)
                }
            }
        }
    }
}