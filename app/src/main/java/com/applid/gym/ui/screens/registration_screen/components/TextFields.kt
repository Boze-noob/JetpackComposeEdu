package com.applid.gym.ui.screens.registration_screen.components

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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.applid.gym.R
import com.applid.gym.ui.common.ButtonWithIcon
import com.applid.gym.ui.view_models.signUp.SignUpEvent
import com.applid.gym.ui.view_models.signUp.SignUpViewModel

@Composable
fun TextFields(
    viewModel: SignUpViewModel = hiltViewModel()
) {
    Column {
        UserNameTextField(viewModel = viewModel)
        Spacer(modifier = Modifier.height(10.dp))
        EmailTextField(viewModel = viewModel)
        Spacer(modifier = Modifier.height(10.dp))
        PasswordTextField(viewModel = viewModel)
        Spacer(modifier = Modifier.height(10.dp))
        RepeatPasswordTextField(viewModel = viewModel)
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
                onClickCallback = {
                    viewModel.onEvent(SignUpEvent.SignUp)
                },
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
fun PasswordTextField(viewModel: SignUpViewModel){
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    TextField(
        value = viewModel.password,
        label = { Text(text = "Password") },
        onValueChange = { it ->
            viewModel.onEvent(SignUpEvent.OnPasswordChange(it))
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
fun RepeatPasswordTextField(viewModel: SignUpViewModel){
    var repeatPasswordVisible by rememberSaveable { mutableStateOf(false) }
    TextField(
        value = viewModel.confirmPassword,
        label = { Text(text = "Confirm password") },
        onValueChange = { it ->
            viewModel.onEvent(SignUpEvent.OnConfirmPasswordChange(it))
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
fun UserNameTextField(viewModel: SignUpViewModel){
    TextField(
        value = viewModel.username,
        label = { Text(text = "Full name") },
        onValueChange = { it ->
            viewModel.onEvent(SignUpEvent.OnUsernameChange(it))
        },
        leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "emailIcon") },
        placeholder = { Text(text = "Enter your full name") },
        colors = getColors(),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun EmailTextField(viewModel: SignUpViewModel){
    TextField(
        value = viewModel.email,
        label = { Text(text = "E-mail") },
        onValueChange = { it ->
            viewModel.onEvent(SignUpEvent.OnEmailChange(it))
        },
        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
        placeholder = { Text(text = "Enter your e-mail") },
        colors = getColors(),
        modifier = Modifier.fillMaxWidth()
    )
}

