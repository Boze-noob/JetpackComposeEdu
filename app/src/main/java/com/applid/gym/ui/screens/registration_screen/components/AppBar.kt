package com.applid.gym.ui.screens.registration_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.applid.gym.ui.helpers.ScreenSize

@Composable
@Preview
fun AppBar() {

    val screenHeight = ScreenSize(LocalContext.current).getScreenHeight()
    Column() {
        IconButton(modifier = Modifier.
        then(Modifier.size(24.dp)),
            onClick = { }) {
            Icon(
                Icons.Filled.ArrowBack,
                "contentDescription",
                tint = Color.White)
        }
        Spacer(modifier = Modifier.height((screenHeight / 5.5).dp))
        Text(text = "Create Account", style = MaterialTheme.typography.h1, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(10.dp))
    }
}