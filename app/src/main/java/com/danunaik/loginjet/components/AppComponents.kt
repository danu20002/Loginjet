package com.danunaik.loginjet.components

import android.util.Log
import android.widget.CheckBox
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danunaik.loginjet.R

@Preview(showBackground = true)
@Composable
fun AppComponent(){
NormalTextComponent(value = "Hey")
    HeaderTextComponent(value = "goods")
}


@Composable
fun NormalTextComponent(value:String,){

     Text(text = value, modifier = Modifier
         .fillMaxWidth()
         .heightIn(min = 20.dp),
         textAlign = TextAlign.Center,
         style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Normal), color = colorResource(
             id = R.color.black
         ))
}

@Composable
fun HeaderTextComponent(value:String,){

    Text(text = value, modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 80.dp),
        textAlign = TextAlign.Center,
        style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold), color = colorResource(
            id = R.color.black
        ))
}

@Composable
fun MyTextField(labelValue:String,painter:Painter){
    val textValue= remember {
        mutableStateOf("")
    }


    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = labelValue) },
       keyboardOptions = KeyboardOptions.Default,
        
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        leadingIcon = {
            Icon(painter = painter, contentDescription ="" )
        }
    )
}

@Composable
fun PasswordTextField(labelValue:String,painter:Painter){
    val password= remember {
        mutableStateOf("")
    }



    val passwordVisible= remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = labelValue) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),




        value = password.value,
        onValueChange = {
            password.value = it
        },
        leadingIcon = {
            Icon(painter = painter, contentDescription ="" )
        },
        trailingIcon = {
               val iconImage=if(passwordVisible.value){
                   Icons.Filled.Visibility
               }else{
                   Icons.Filled.VisibilityOff
               }
            val description=if(passwordVisible.value){
                "Hide Password"
            }else{
                "Show Password"
            }

            IconButton(onClick = {passwordVisible.value=!passwordVisible.value}) {
                Icon(imageVector = iconImage, contentDescription =description )
            }
        },
        visualTransformation = if(passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()

    )
}

@Composable
fun CheckBoxComoponent(value: String,onTextselected: (String) -> Unit){
    Row(modifier = Modifier
        .fillMaxWidth()


        .heightIn(56.dp), verticalAlignment = Alignment.CenterVertically) {
          val checkedState= remember {
              mutableStateOf(false)
          }
        Checkbox(checked = checkedState.value, onCheckedChange ={
            checkedState.value =!checkedState.value
        } )
        ClickableTextComponent(value = value,onTextselected)
    }
}

@Composable
fun ClickableTextComponent(value: String,onTextselected:(String)->Unit){

    val initialString="By Continuing you accept our "
    val privacyText="Privacy and Policy "
    val andText="and "
    val termsAndConditions="Terms and Conditions"
    val annaotatedString= buildAnnotatedString {
        append(initialString)
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)){
            pushStringAnnotation(tag = privacyText, annotation = privacyText)
            append(privacyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)){
            pushStringAnnotation(tag = termsAndConditions, annotation = termsAndConditions)
            append(termsAndConditions)
        }
    }
   ClickableText(text = annaotatedString, onClick = { offset ->
       annaotatedString.getStringAnnotations(offset,offset).firstOrNull()?.also { span->
           run {
               Log.d("Cliked textCompoent", "{${span.item}}")
              if((span.item == termsAndConditions) || (span.item == privacyText)){
                  onTextselected(span.item)
              }
           }
       }
   }) 
}

@Composable
fun ButtonComponent(value: String){
    Button(onClick = { /*TODO*/ }, modifier = Modifier
        .fillMaxWidth()
        .heightIn(48.dp), contentPadding = PaddingValues(), colors = ButtonDefaults.buttonColors(
        Color.Transparent), shape = RoundedCornerShape(50.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp)
            .background(
                brush = Brush.horizontalGradient(
                    listOf(MaterialTheme.colorScheme.primary, MaterialTheme.colorScheme.secondary)
                ), shape = RoundedCornerShape(50.dp)
            ), contentAlignment = Alignment.Center) {
            Text(text = value, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }

}


@Composable
fun DividerTExtComponent(){
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f), color = Color.Gray, thickness = 1.dp)

        Text(text = "Or", modifier = Modifier.padding(8.dp), fontSize = 14.sp, color = Color.Black)

        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f), color = Color.Gray, thickness = 1.dp)
    }
}