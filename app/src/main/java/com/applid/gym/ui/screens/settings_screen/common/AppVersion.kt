package com.applid.gym.ui.screens.settings_screen.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun AppVersion(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "App version : 1.0.0",
            style = MaterialTheme.typography.h3,
            color = Color.Black
        )
        Text(text = "Made with love by ...",
            style = MaterialTheme.typography.subtitle1,
            color = Color.Black
            )
    }
}