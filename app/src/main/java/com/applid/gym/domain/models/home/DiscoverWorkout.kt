package com.applid.gym.domain.models.home

import androidx.compose.ui.graphics.Color
import android.media.Image

data class DiscoverWorkout(
    val title: String,
    val numOfExercises : String,
    val time : String,
    val backgroundColor : Color,
    val image : String,
    )
