package com.applid.gym.domain.use_cases.sign_in

import com.applid.gym.common.Resource
import com.applid.gym.domain.models.sign_in.SignInModel
import com.applid.gym.domain.repositories.SignInRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class SignInUserUseCase @Inject constructor(
    private val signInRepository: SignInRepository
){
    operator fun invoke(signInModel: SignInModel) : Flow<Resource<SignInModel>> = flow {
        try{
            emit(Resource.Loading<SignInModel>())
            val result = signInRepository.postSignIn(signInModel = signInModel)
            emit(Resource.Success<SignInModel>(result))
        } catch (e : HttpException) {
            emit(Resource.Error<SignInModel>(message = e.localizedMessage ?: "An unexpected error happen, try again later"))
        } catch (e : IOException) {
            emit(Resource.Error<SignInModel>(message = e.localizedMessage ?: "Error happen, check your internet connection"))
        }
    }
}