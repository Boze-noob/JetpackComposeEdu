package com.applid.gym.ui.view_models.home.userProgressPercentage

import com.applid.gym.domain.models.home.UserProgressPercentage

data class UserProgressPercentageState(
    val isLoading : Boolean = false,
    val userProgressPercentage: UserProgressPercentage? = UserProgressPercentage(progressPercentage = 0.0),
    val error : String = ""
)
