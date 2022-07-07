package com.applid.gym.data.api.dto

import com.applid.gym.domain.models.User
import dagger.multibindings.IntoMap

data class UserDto(
    val ID : Int,
    val userName : String,
    val weight : Int,
    val address : String,
    val completedWorkouts : Int
)

fun UserDto.toUser() : User {
    return User(
        userName = userName,
        weight = weight,
        address = address,
        completedWorkouts = completedWorkouts
    )
}
