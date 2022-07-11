package com.applid.gym.ui.view_models.home.basicInfo

sealed class BasicInfoEvent{
    data class Init(val subscriptionID : Int) : BasicInfoEvent()
}
