package com.applid.gym.data.api.dto.home

import com.applid.gym.domain.models.home.UserProgressPercentage

data class UserProgressPercentageDto(
    val progressPercentage : Double
)

fun UserProgressPercentageDto.toUserProgressPercentage() : UserProgressPercentage {
    return UserProgressPercentage(
        progressPercentage = progressPercentage
    )
}


