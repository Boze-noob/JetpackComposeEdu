package com.applid.gym.util

sealed class UiEvent {
    data class ShowSnackBar(
        val message : String
    ) : UiEvent()
}
