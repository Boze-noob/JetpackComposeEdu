package com.applid.gym.ui.view_models.home_screen

sealed class BasicInfoEvent{
    data class Init(val userID : String) : BasicInfoEvent()
}
