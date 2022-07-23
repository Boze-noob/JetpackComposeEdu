package com.applid.gym.ui.view_models.signUp

import com.applid.gym.domain.models.sign_up.SignUpModel

sealed class SignUpEvent {
    object SignUp : SignUpEvent()
    data class OnUsernameChange(val username: String) : SignUpEvent()
    data class OnPasswordChange(val password: String) : SignUpEvent()
    data class OnConfirmPasswordChange(val confirmPassword: String) : SignUpEvent()
    data class OnEmailChange(val email: String) : SignUpEvent()
}