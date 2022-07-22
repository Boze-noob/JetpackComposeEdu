package com.applid.gym.data.repositories

import com.applid.gym.data.api.Api
import com.applid.gym.domain.models.sign_up.SignUpModel
import com.applid.gym.domain.repositories.SignUpRepository
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(
    private val api: Api
) : SignUpRepository {

    override suspend fun postSignUp(signUpModel: SignUpModel): SignUpModel {
        return api.postSignUp(signUpModel = signUpModel)
    }
}

