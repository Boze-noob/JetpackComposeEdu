package com.applid.gym.data.api.dto

import com.applid.gym.domain.models.User
import com.applid.gym.domain.models.common.WebImageModel

data class UserDto(
    val ID: Int,
    val username: String,
    val email: String,
    val weight: Int,
    val address: String,
    val exerciseId: Int? = null,
    val subscriptionId: Int? = null,
    val completedWorkouts: Int? = null,
    val profileImage: String? = null,
)

fun UserDto.toUser() : User {
    return User(
        userName = username,
        weight = weight,
        address = address,
        completedWorkouts = completedWorkouts
    )
}

fun UserDto.toWebImageModel() : WebImageModel {
    return WebImageModel(
        url = profileImage,
    )
}
