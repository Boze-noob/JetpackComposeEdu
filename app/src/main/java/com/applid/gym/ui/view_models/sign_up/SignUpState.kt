package com.applid.gym.ui.view_models.sign_up

import com.applid.gym.domain.models.sign_up.SignUpModel

data class SignUpState(
    val isLoading: Boolean = false,
    val signUpModel: SignUpModel? = null,
    val error: String = "",
)
