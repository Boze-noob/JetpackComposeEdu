package com.applid.gym.data.api.dto.home

import com.applid.gym.domain.models.home.BasicInfo

data class BasicInfoDto(
    val completedWorkouts : Int,
    val weight : Int,
    val daysLeft : Int,
)

fun BasicInfoDto.toBasicInfo() : BasicInfo{
    return BasicInfo(
        completedWorkouts = completedWorkouts,
        weight = weight,
        daysLeft = daysLeft
    )
}
