package com.applid.gym.ui.screens.login_screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.applid.gym.ui.common.ButtonWithRoundCornerShape
import com.applid.gym.ui.helpers.ScreenSize
import com.applid.gym.ui.screens.login_screen.components.AppBar
import com.applid.gym.ui.screens.login_screen.components.TextFields
import com.applid.gym.ui.theme.GymTheme
import com.applid.gym.ui.view_models.sign_in.SignInViewModel
import com.applid.gym.util.UiEvent

class LoginScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent() {
            GymTheme() {
               Body()
            }
        }
    }
}

@Composable
fun Body(
    viewModel: SignInViewModel = hiltViewModel()
){
    val screenHeight = ScreenSize(LocalContext.current).getScreenHeight()
    val scaffoldState = rememberScaffoldState()
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect {
                event ->
            when(event) {
                is UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message,
                    )
                }

            }
        }
    }
    Scaffold(
        bottomBar = { BottomAppBar() {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Don't have an account?", style = MaterialTheme.typography.subtitle1)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Sign up", style = MaterialTheme.typography.h3, modifier = Modifier.clickable {
                })
            }
        }
        }
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Spacer(modifier = Modifier.height((screenHeight / 4.5).dp))
            AppBar()
            Spacer(modifier = Modifier.height(30.dp))
            TextFields()
        }
    }
}