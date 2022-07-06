package com.applid.gym.ui.screens.leaderboard_screen.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalExerciseList(exercises : List<String>){
    LazyRow(){
        items(items = exercises){
            exercise -> Text(
            text = exercise,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(horizontal = 10.dp)
        )
        }
    }
}