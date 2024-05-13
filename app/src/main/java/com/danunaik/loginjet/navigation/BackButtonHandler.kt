package com.danunaik.loginjet.navigation

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalBackPressedDispatcher= staticCompositionLocalOf<OnBackPressedDispatcherOwner?> { null }

private class ComposeBackNavigationHandler(enabled:Boolean) :OnBackPressedCallback(enabled){
    lateinit var onBackPressed:()->Unit
    override fun handleOnBackPressed() {
        onBackPressed
    }
}