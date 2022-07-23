package com.applid.gym.domain.repositories

import com.applid.gym.domain.models.sign_in.SignInModel

interface SignInRepository {
    suspend fun postSignIn(signInModel: SignInModel) : SignInModel
}