package com.applid.gym.ui.screens.home_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.applid.gym.R
import com.applid.gym.ui.common.AutoSizeText

@Composable
fun MotivationQuote() {
    Row() {
        Image(
            painterResource(R.drawable.trophy_icon),
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(50.dp, 50.dp)
                .weight(1F)
        )
        Column(
            modifier = Modifier.weight(3F)
        ) {
            AutoSizeText(text = "Keep the progress!", textStyle = TextStyle(
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.open_sans)
                )
            ))
            Spacer(modifier = Modifier.height(7.dp))
            Text(
                text = "You are more successful than 80% of the users.",
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.open_sans)),
                fontSize = 14.sp
            )
        }
    }
}