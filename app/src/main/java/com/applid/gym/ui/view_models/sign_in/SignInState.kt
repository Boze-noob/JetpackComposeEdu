package com.applid.gym.ui.view_models.sign_in

import com.applid.gym.domain.models.sign_in.SignInModel

data class SignInState(
    val isLoading: Boolean = false,
    val signInModel: SignInModel? = null,
    val error: String = "",
)
