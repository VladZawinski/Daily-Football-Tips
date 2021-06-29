package com.escatatic.shahadtips.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

abstract class DataBindingFragment<VB: ViewDataBinding>: BaseFragment() {

    lateinit var viewBinding: VB

    @get:LayoutRes
    abstract val layoutRes: Int


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate<VB>(inflater,layoutRes,container,false)
        return viewBinding.root
    }

    fun showSnackBar(message: String,root: View){
        Snackbar.make(viewBinding.root,message, Snackbar.LENGTH_LONG).show()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

    }





}