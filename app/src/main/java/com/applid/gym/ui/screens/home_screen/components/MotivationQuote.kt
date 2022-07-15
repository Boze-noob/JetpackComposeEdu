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
import androidx.hilt.navigation.compose.hiltViewModel
import com.applid.gym.R
import com.applid.gym.ui.common.AutoSizeText
import com.applid.gym.ui.view_models.home.userProgressPercentage.UserProgressPercentageState
import com.applid.gym.ui.view_models.home.userProgressPercentage.UserProgressPercentageViewModel
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun MotivationQuote(
    viewModel: UserProgressPercentageViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val quote = getPercentage(state)

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
                text = quote,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.open_sans)),
                fontSize = 14.sp
            )
        }
    }
}

fun getPercentage(state : UserProgressPercentageState) : String {
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.CEILING

    if(state.userProgressPercentage != null){
        if(state.userProgressPercentage.progressPercentage == 100.0)
            return "You are better than all other users"
        else if(state.userProgressPercentage.progressPercentage == 0.0)
            return "You are at the bottom of a leaderboard. Work harder!"
        else return "You are more successful than ${df.format(state.userProgressPercentage.progressPercentage)}% of the users."
    }
    else return "Slow progress is better than no progress!"
}