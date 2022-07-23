package com.applid.gym.ui.view_models.sign_in

sealed class SignInEvent{
    object SignIn : SignInEvent()
    object OnForgotPassword : SignInEvent()
    data class OnEmailChange(val email: String) : SignInEvent()
    data class OnPasswordChange(val password: String) : SignInEvent()
}
