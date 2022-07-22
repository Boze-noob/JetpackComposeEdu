package com.applid.gym.ui.view_models.signUp

import com.applid.gym.domain.models.sign_up.SignUpModel

sealed class SignUpEvent {
    data class SignUp(val signUpModel: SignUpModel) : SignUpEvent()
}