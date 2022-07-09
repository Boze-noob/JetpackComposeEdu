package com.applid.gym.data.api.dto.home

import androidx.compose.ui.graphics.Color
import com.applid.gym.domain.models.home.DiscoverWorkout

data class DiscoverWorkoutDto(
    val title : String,
    val numOfExercises : String,
    val time : String,
    val backgroundColor : Color,
    val image : Int,
)

fun DiscoverWorkoutDto.toDiscoverWorkout() : DiscoverWorkout{
    return DiscoverWorkout(
        title = title,
        numOfExercises = numOfExercises,
        time = time,
        backgroundColor = backgroundColor,
        image = image
    )
}

