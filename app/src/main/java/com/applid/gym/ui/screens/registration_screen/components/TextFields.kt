package com.applid.gym.ui.screens.registration_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.applid.gym.R
import com.applid.gym.ui.common.ButtonWithIcon

@Composable
fun TextFields() {


    Column {

        UserNameTextField()
        Spacer(modifier = Modifier.height(10.dp))
        EmailTextField()
        Spacer(modifier = Modifier.height(10.dp))
        PasswordTextField()
        Spacer(modifier = Modifier.height(10.dp))
        RepeatPasswordTextField()
        Spacer(modifier = Modifier.height(5.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 20.dp),
            horizontalAlignment = Alignment.End
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            ButtonWithIcon(
                btnTxt = "SIGN UP",
                onClickCallback = { },
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 7.dp),
            )
        }
    }
}

@Composable
fun getColors() : TextFieldColors {
    return TextFieldDefaults.textFieldColors(
        textColor = Color.Gray,
        disabledTextColor = Color.Transparent,
        backgroundColor = Color.Transparent,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        focusedLabelColor = Color.Black
    )
}

@Composable
fun PasswordTextField(){
    var passwordText by remember { mutableStateOf(TextFieldValue("")) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    TextField(
        value = passwordText,
        label = { Text(text = "Password") },
        onValueChange = { it ->
            passwordText = it
        },
        leadingIcon = { Icon(painter = painterResource(id = R.drawable.password_field_icon), contentDescription = "") },
        placeholder = { Text(text = "Enter your password") },
        singleLine = true,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        colors = getColors(),
        trailingIcon = {
            IconButton(onClick = {passwordVisible = !passwordVisible}) {
                Icon(painter = painterResource(id = if(passwordVisible) R.drawable.hide_icon else R.drawable.show_icon),
                    contentDescription = "", )
            } },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun RepeatPasswordTextField(){
    var repeatPasswordText by remember { mutableStateOf(TextFieldValue("")) }
    var repeatPasswordVisible by rememberSaveable { mutableStateOf(false) }

    TextField(
        value = repeatPasswordText,
        label = { Text(text = "Confirm password") },
        onValueChange = { it ->
            repeatPasswordText = it
        },
        leadingIcon = { Icon(painter = painterResource(id = R.drawable.password_field_icon), contentDescription = "") },
        placeholder = { Text(text = "Enter your password") },
        singleLine = true,
        visualTransformation = if (repeatPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        colors = getColors(),
        trailingIcon = {
            IconButton(onClick = {repeatPasswordVisible = !repeatPasswordVisible}) {
                Icon(painter = painterResource(id = if(repeatPasswordVisible) R.drawable.hide_icon else R.drawable.show_icon),
                    contentDescription = "", )
            } },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun UserNameTextField(){
    var userNameText by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = userNameText,
        label = { Text(text = "Full name") },
        onValueChange = { it ->
            userNameText = it
        },
        leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "emailIcon") },
        placeholder = { Text(text = "Enter your full name") },
        colors = getColors(),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun EmailTextField(){
    var emailText by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = emailText,
        label = { Text(text = "E-mail") },
        onValueChange = { it ->
            emailText = it
        },
        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
        placeholder = { Text(text = "Enter your e-mail") },
        colors = getColors(),
        modifier = Modifier.fillMaxWidth()
    )
}

