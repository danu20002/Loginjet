package com.danunaik.loginjet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.danunaik.loginjet.Screens.SignupScreen
import com.danunaik.loginjet.Screens.TermsAndConditions
import com.danunaik.loginjet.navigation.AppScreenNavigation
import com.danunaik.loginjet.navigation.Screen
import com.danunaik.loginjet.ui.theme.LoginJetTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {
    private val auth:FirebaseAuth by lazy { Firebase.auth }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginJetTheme {
                // A surface container using the 'background' color from the theme

                Crossfade(targetState = AppScreenNavigation.CurrentDcreen) {
                    curenntState->
                    when(curenntState.value){

                        is Screen.SignUpScreen->{
                            SignupScreen()
                        }
                        is Screen.TermsAndConditions->{
                                    TermsAndConditions()
                        }
                }
                }

            }
        }
    }
}

