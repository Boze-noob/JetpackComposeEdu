package com.applid.gym.ui.view_models.home.userProgressPercentage

sealed class UserProgressPercentageEvent {
    data class Init(val exerciseID : Int) : UserProgressPercentageEvent()
}
