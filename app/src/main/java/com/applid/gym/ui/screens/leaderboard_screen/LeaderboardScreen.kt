package com.applid.gym.ui.screens.leaderboard_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.applid.gym.R
import com.applid.gym.ui.screens.leaderboard_screen.components.AppBar
import com.applid.gym.ui.screens.leaderboard_screen.components.BestThreeInfo
import com.applid.gym.ui.screens.leaderboard_screen.components.HorizontalExerciseList
import com.applid.gym.ui.screens.leaderboard_screen.components.LeaderboardItem

@Composable
fun LeaderboardScreen() {
    LazyColumn(
    ) {
        item {
            Box(modifier = Modifier.background(color = Color.Blue)){
                Column {
                    AppBar()
                    Spacer(modifier = Modifier.height(20.dp))
                    HorizontalExerciseList(exercises = listOf("Exercise 1", "Exercise 2", "Exercise 3", "Exercise 4", "Exercise 5" ))
                    Spacer(modifier = Modifier.height(20.dp))
                    BestThreeInfo()
                }
            }
        }
        item {
            Image(
                painterResource(R.drawable.wave),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxWidth()
            )
        }
        items(20){
            item -> LeaderboardItem(place = item)
        }
        item { 
            Spacer(modifier = Modifier.height(56.dp))
        }

    }
}