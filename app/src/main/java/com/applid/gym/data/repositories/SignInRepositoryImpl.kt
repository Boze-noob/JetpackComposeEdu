package com.applid.gym.data.repositories

import com.applid.gym.data.api.Api
import com.applid.gym.domain.models.sign_in.SignInModel
import com.applid.gym.domain.repositories.SignInRepository
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(
    private val api: Api
) : SignInRepository {
    override suspend fun postSignIn(signInModel: SignInModel): SignInModel {
        return api.postSignIn(signInModel = signInModel)
    }
}