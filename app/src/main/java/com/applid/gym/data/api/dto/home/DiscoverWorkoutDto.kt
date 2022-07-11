package com.applid.gym.data.api.dto.home

import androidx.compose.ui.graphics.Color
import com.applid.gym.domain.models.home.DiscoverWorkout

data class DiscoverWorkoutDto(
    val Title : String,
    val Num_of_exercises : String,
    val Time : String,
    val Background_color : String,
    val Image : String,
)

fun DiscoverWorkoutDto.toDiscoverWorkout() : DiscoverWorkout{
    return DiscoverWorkout(
        title = Title,
        numOfExercises = Num_of_exercises,
        time = Time,
        backgroundColor = Background_color,
        image = Image
    )
}

