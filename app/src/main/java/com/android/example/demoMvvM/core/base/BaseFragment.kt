package com.android.example.demoMvvM.core.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.udacity.project4.core.base.NavigationCommand

/**
 * Base Fragment to observe on the common LiveData objects
 */
abstract class BaseFragment : Fragment() {
    /**
     * Every fragment has to have an instance of a view model that extends from the BaseViewModel
     */
    abstract val _viewModel: BaseViewModel

    override fun onStart() {
        super.onStart()

        _viewModel.showSnackBar.observe(this, Observer {
            Snackbar.make(this.requireView(), it, Snackbar.LENGTH_SHORT).show()
        })


        _viewModel.navigationCommand.observe(this, Observer { command ->
            when (command) {
                is NavigationCommand.Back -> findNavController().popBackStack()
            }
        })
    }
}