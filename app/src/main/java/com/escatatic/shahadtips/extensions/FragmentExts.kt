package com.escatatic.shahadtips.extensions
import android.widget.ViewFlipper
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.MaterialToolbar

fun Fragment.addBackButtonIfToolbarExists(toolbar: MaterialToolbar){
    (requireActivity() as AppCompatActivity).apply {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    toolbar.setNavigationOnClickListener {
        findNavController().navigateUp()
    }

}

fun Fragment.addBackButtonWithEmptyTitle(toolbar: MaterialToolbar){
    (requireActivity() as AppCompatActivity).apply {
        toolbar.title = ""
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }
    toolbar.setNavigationOnClickListener {
        findNavController().navigateUp()
    }
}

//fun MaterialToolbar.onBackButtonClicked(onClick: () -> Unit){
//    setNavigationOnClickListener {
//        onClick()
//    }
//}

fun Fragment.addDefaultSlideAnimationToViewFlipper(flipper: ViewFlipper){
    flipper.setInAnimation(requireContext(),android.R.anim.slide_in_left)
    flipper.setOutAnimation(requireContext(),android.R.anim.slide_out_right)
}