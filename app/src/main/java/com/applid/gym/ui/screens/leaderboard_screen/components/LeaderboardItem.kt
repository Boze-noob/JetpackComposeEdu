package com.applid.gym.ui.screens.leaderboard_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.applid.gym.R

@Composable
fun LeaderboardItem(place : Int = 1, image : Int = R.drawable.trophy_icon, userName : String = "User name", score : Int = 2500){
    Row(
        modifier = Modifier.padding(vertical = 5.dp)
    ) {
        Text(
            text = place.toString(),
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier
                .weight(0.6f)
                .padding(start = 7.dp)
        )
        Image(
            painterResource(image),
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .width(20.dp)
                .weight(1f)

        )
        Text(
            text = userName,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.weight(4f)
        )
        Text(
            text = score.toString(),
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.weight(1f)
        )
        Icon(
            imageVector = Icons.Rounded.Star,
            tint = Color.Yellow,
            contentDescription = "",
            modifier = Modifier.weight(1f)
        )
    }

}