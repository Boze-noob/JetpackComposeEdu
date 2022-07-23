package com.applid.gym.domain.use_cases.sign_up

import com.applid.gym.common.Resource
import com.applid.gym.domain.models.sign_up.SignUpModel
import com.applid.gym.domain.repositories.SignUpRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SignUpUserUseCase @Inject constructor(
    private val signUpRepository: SignUpRepository
){
    operator fun invoke(signUpModel: SignUpModel) : Flow<Resource<SignUpModel>> = flow{
        try{
            emit(Resource.Loading<SignUpModel>())
            val result = signUpRepository.postSignUp(signUpModel = signUpModel)
            emit(Resource.Success<SignUpModel>(result))
        } catch (e : HttpException) {
            emit(Resource.Error<SignUpModel>(message = e.localizedMessage ?: "An unexpected error happen, try again later"))
        } catch (e : IOException) {
            emit(Resource.Error<SignUpModel>(message = e.localizedMessage ?: "Error happen, check your internet connection"))
        }
    }
}