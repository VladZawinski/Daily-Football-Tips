package com.escatatic.shahadtips

import android.os.Bundle
import androidx.navigation.findNavController
import com.escatatic.shahadtips.base.DataBindingActivity
import com.escatatic.shahadtips.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity(
    override val layoutRes: Int = R.layout.activity_main
) : DataBindingActivity<ActivityMainBinding>(){

    override fun onCreate(savedInstanceState: Bundle?) {
        makeStatusBarWhite()
        super.onCreate(savedInstanceState)

        val navController = findNavController(R.id.mainNavHostFragment)
        navController.addOnDestinationChangedListener { controller, destination, arguments ->

        }
    }
}