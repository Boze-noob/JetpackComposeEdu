package com.applid.gym.data.api.dto

import com.applid.gym.domain.models.Exercise

data class ExerciseDto (
    val ID : Int,
    val pushUps : Int,
    val squats : Int,
    val bench : Int,
    val pullUps : Int,
)

fun ExerciseDto.toExercise() : Exercise {
    return Exercise(
        pushUps = pushUps,
        squats = squats,
        bench = bench,
        pullUps = pullUps
    )
}



