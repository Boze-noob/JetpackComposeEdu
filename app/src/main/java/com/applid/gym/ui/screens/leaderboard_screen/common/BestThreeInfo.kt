package com.applid.gym.ui.screens.leaderboard_screen.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.applid.gym.R

@Composable
fun BestThreeInfo(){
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            //Its not possible to use column weight inside another fun, so I move this code from CircleWithTxt fun here
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(weight = 1f),
        ) {
            CircleWithTxt(text = "2", textSize = 16.sp, padding = 7, width = 60, height = 60, "Ivan Ivic")
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(weight = 1f),
        ) {
            CircleWithImage(
                image = R.drawable.trophy_icon,
                padding = 7,
                width = 100,
                height = 100,
                userName = "Petar Peric"
            )
        }

        Column(
            //Its not possible to use weight inside another fun, so I move this code from CircleWithTxt fun here
            modifier = Modifier.weight(weight = 1f),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CircleWithTxt(text = "3", textSize = 16.sp, padding = 7, width = 60, height = 60, "Nikola Nikic")
        }

    }
}

@Composable
fun CircleWithTxt(text : String, textSize : TextUnit, padding : Int, width : Int, height : Int, userName : String){
        Box(modifier = Modifier
            .padding(padding.dp)
            .width(width.dp)
            .height(height.dp)
            .aspectRatio(1f)
            .background(Color.DarkGray.copy(alpha = 0.3f), shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(text, style = MaterialTheme.typography.subtitle1, fontSize = textSize)
        }
    Spacer(modifier = Modifier.height(7.dp))
    Text(
        text = userName,
        style = MaterialTheme.typography.subtitle1,
    )
}

@Composable
fun CircleWithImage(image : Int, padding : Int, width : Int, height : Int, userName : String){
    Box(modifier = Modifier
        .padding(padding.dp)
        .width(width.dp)
        .height(height.dp)
        .aspectRatio(1f)
        .background(Color.DarkGray.copy(alpha = 0.3f), shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painterResource(image),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.size((width - 20).dp, (height - 20).dp)
            )
        }
    Spacer(modifier = Modifier.height(7.dp))
    Text(
        text = userName,
        style = MaterialTheme.typography.subtitle1,
    )
}