package com.applid.gym.ui.view_models.home.appBar

sealed class AppBarEvent {
    data class Init(val userId : Int) : AppBarEvent()
}