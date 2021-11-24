package com.udacity.project4.core.base

import androidx.navigation.NavDirections

/**
 * Sealed class used with the live data to navigate between the fragments
 */
sealed class NavigationCommand {

    /**
     * navigate back to the previous fragment
     */
    object Back : NavigationCommand()

}