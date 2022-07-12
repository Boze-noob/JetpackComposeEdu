package com.applid.gym.data.api.dto

import com.applid.gym.domain.models.User
import com.applid.gym.domain.models.common.WebImageModel

data class UserDto(
    val ID: Int,
    val userName: String,
    val weight: Int,
    val address: String,
    val completedWorkouts: Int? = null,
    val profileImageUrl: String? = null,
)

fun UserDto.toUser() : User {
    return User(
        userName = userName,
        weight = weight,
        address = address,
        completedWorkouts = completedWorkouts
    )
}

fun UserDto.toWebImageModel() : WebImageModel {
    return WebImageModel(
        url = profileImageUrl
    )
}
