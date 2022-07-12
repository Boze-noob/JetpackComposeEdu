package com.applid.gym.domain.models

data class User(
    val userName : String,
    val weight : Int,
    val address : String,
    val completedWorkouts : Int? = null
)
