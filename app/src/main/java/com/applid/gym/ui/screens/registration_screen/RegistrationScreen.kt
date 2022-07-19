package com.applid.gym.ui.screens.registration_screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.applid.gym.ui.helpers.ScreenSize
import com.applid.gym.ui.screens.registration_screen.components.AppBar
import com.applid.gym.ui.screens.registration_screen.components.TextFields
import com.applid.gym.ui.theme.GymTheme

class RegistrationScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContent() {
            val screenHeight = ScreenSize(LocalContext.current).getScreenHeight()
            GymTheme() {
                Scaffold(

                    bottomBar = { BottomAppBar() {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = "Already have a account?", style = MaterialTheme.typography.subtitle1)
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(text = "Sign in", style = MaterialTheme.typography.h3, modifier = Modifier.clickable {

                            })
                        }
                    }
                    }
                ) {
                    Column(
                        modifier = Modifier.padding(horizontal = 10.dp).verticalScroll(rememberScrollState())
                    ) {
                        Spacer(modifier = Modifier.height((screenHeight / 14).dp))
                        AppBar()
                        Spacer(modifier = Modifier.height(30.dp))
                        TextFields()
                    }
                }
            }
        }
    }
}