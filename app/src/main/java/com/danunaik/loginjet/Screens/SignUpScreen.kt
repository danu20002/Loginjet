package com.danunaik.loginjet.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danunaik.loginjet.R
import com.danunaik.loginjet.components.ButtonComponent
import com.danunaik.loginjet.components.CheckBoxComoponent
import com.danunaik.loginjet.components.DividerTExtComponent
import com.danunaik.loginjet.components.HeaderTextComponent
import com.danunaik.loginjet.components.MyTextField
import com.danunaik.loginjet.components.NormalTextComponent
import com.danunaik.loginjet.components.PasswordTextField
import com.danunaik.loginjet.navigation.AppScreenNavigation
import com.danunaik.loginjet.navigation.Screen

@Composable
fun SignupScreen(){
        Surface(color = Color.White, modifier = Modifier
            .fillMaxSize()
            .padding(28.dp)) {

            Column(modifier = Modifier.fillMaxSize()) {
                NormalTextComponent(value = stringResource(id = R.string.hey_there ) )
                HeaderTextComponent(value = stringResource(id = R.string.createaccount))
                MyTextField(labelValue = stringResource(id = R.string.firstname), painter = painterResource(
                    id = R.drawable.baseline_person_24
                ))

                MyTextField(labelValue = stringResource(id = R.string.lastname), painter = painterResource(
                    id = R.drawable.baseline_person_24
                ))
               MyTextField(labelValue = stringResource(id = R.string.email), painter = painterResource(
                   id = R.drawable.baseline_email_24
               ))
                PasswordTextField(labelValue = stringResource(id = R.string.password), painter = painterResource(
                    id = R.drawable.baseline_password_24
                ) )
                CheckBoxComoponent(value = stringResource(id = R.string.terms_and_conditions), onTextselected = {
                    AppScreenNavigation.navigationTo(Screen.TermsAndConditions)
                } )
                Spacer(modifier = Modifier.height(80.dp))
                ButtonComponent(value = stringResource(id = R.string.register))
                
                Spacer(modifier = Modifier.height(20.dp))
                DividerTExtComponent()
            }

        }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreviewSignupScreen(){
    SignupScreen()
}