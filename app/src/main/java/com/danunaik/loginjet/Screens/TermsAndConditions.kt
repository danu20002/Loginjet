package com.danunaik.loginjet.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.danunaik.loginjet.components.HeaderTextComponent


@Composable 
fun TermsAndConditions(){
    Surface(modifier = Modifier.fillMaxSize().background(color = Color.White), color = Color.White) {
        HeaderTextComponent(value = "Terms and Conditions")

    }

}