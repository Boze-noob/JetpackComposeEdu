package com.applid.gym.domain.repositories

import com.applid.gym.domain.models.sign_up.SignUpModel

interface SignUpRepository {
    suspend fun postSignUp(signUpModel : SignUpModel) : SignUpModel
}