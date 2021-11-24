package com.android.example.demoMvvM.core.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.android.example.demoMvvM.core.util.SingleLiveEvent
import com.udacity.project4.core.base.NavigationCommand

/**
 * Base class for View Models to declare the common LiveData objects in one place
 */
abstract class BaseViewModel(app: Application) : AndroidViewModel(app) {

    val navigationCommand: SingleLiveEvent<NavigationCommand> = SingleLiveEvent()
    val showSnackBar: SingleLiveEvent<String> = SingleLiveEvent()
    val showLoading: SingleLiveEvent<Boolean> = SingleLiveEvent()


}