package com.applid.gym.domain.models.sign_in

data class SignInModel(
    val email : String? = "",
    val password : String? = "",
    val message : String? = "",
    val token : String? = ""
)
