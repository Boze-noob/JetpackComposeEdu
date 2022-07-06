package com.applid.gym.ui.screens.leaderboard_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(){
    Column() {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Leaderboard",
                style = MaterialTheme.typography.h1,
                modifier = Modifier.align(Alignment.Center)
                )
            IconButton(
                onClick = { } ,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(5.dp)
            ) {
                Icon(
                    imageVector = Icons.Rounded.Share,
                    tint = Color.Yellow,
                    contentDescription = ""
                )
            }
        }
    }
}