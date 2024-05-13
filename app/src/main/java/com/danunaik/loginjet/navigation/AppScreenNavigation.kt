package com.danunaik.loginjet.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen{
    object  SignUpScreen:Screen()
    object TermsAndConditions:Screen()

}
object AppScreenNavigation{
    var CurrentDcreen:MutableState<Screen> = mutableStateOf(Screen.SignUpScreen)

    fun navigationTo(destination:Screen){
        CurrentDcreen.value=destination
    }
}