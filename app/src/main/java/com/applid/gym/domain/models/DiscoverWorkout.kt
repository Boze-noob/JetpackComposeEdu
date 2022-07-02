package com.applid.gym.domain.models

import androidx.compose.ui.graphics.Color
import android.media.Image

data class DiscoverWorkout(
    val title: String,
    val description : String,
    val backgroundColor : Color,
    val image : Int,
    )