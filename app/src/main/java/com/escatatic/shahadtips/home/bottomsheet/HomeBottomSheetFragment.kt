package com.escatatic.shahadtips.home.bottomsheet

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.escatatic.shahadtips.R
import com.escatatic.shahadtips.databinding.BottomsheetHomeBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class HomeBottomSheetFragment(
    private val onMarkAsWin: () -> Unit,
    private val onMarkAsLose: () -> Unit,
    private val onUpdateScore: (Int,Int) -> Unit,
    private val onSearchOnBrowser: () -> Unit
): BottomSheetDialogFragment(){

    private lateinit var viewBinding : BottomsheetHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater,R.layout.bottomsheet_home,container,false)

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.markAsWinContainer.setOnClickListener {
            onMarkAsWin()
            dismiss()
        }
        viewBinding.searchContainer.setOnClickListener {
            onSearchOnBrowser()
            dismiss()
        }
        viewBinding.markAsLoseContainer.setOnClickListener {
            onMarkAsLose()
            dismiss()
        }
        viewBinding.updateBtn.setOnClickListener {
            val home = viewBinding.homeEditText.text.toString().trim()
            val away = viewBinding.awayEditText.text.toString().trim()

            if (home.isNotEmpty() && away.isNotEmpty()){
                onUpdateScore(home.toInt(),away.toInt())
            }else {
                Toast.makeText(context!!, "Home or Away should not be empty", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog = BottomSheetDialog(context!!,theme)

    override fun getTheme(): Int = R.style.BottomSheetTheme

    companion object{
        fun newInstance(
            onMarkAsWin: () -> Unit,
            onMarkAsLose: () -> Unit,
            onUpdateScore: (Int,Int) -> Unit,
            onSearchOnBrowser: () -> Unit
        ) = HomeBottomSheetFragment(onMarkAsWin,onMarkAsLose,onUpdateScore, onSearchOnBrowser)
    }
}