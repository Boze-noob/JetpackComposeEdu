package com.applid.gym.ui.screens.login_screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomAppBar
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.applid.gym.ui.common.ButtonWithRoundCornerShape
import com.applid.gym.ui.helpers.ScreenSize
import com.applid.gym.ui.screens.login_screen.components.AppBar
import com.applid.gym.ui.screens.login_screen.components.TextFields
import com.applid.gym.ui.theme.GymTheme

class LoginScreen : ComponentActivity() {
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
        }
    }
}