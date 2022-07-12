package com.applid.gym.domain.use_cases.common

import com.applid.gym.common.Resource
import com.applid.gym.data.api.dto.toWebImageModel
import com.applid.gym.domain.models.common.WebImageModel
import com.applid.gym.domain.repositories.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetProfileImageUseCase @Inject constructor(
    private val homeRepository: HomeRepository
){
    operator fun invoke(userID : Int) : Flow<Resource<WebImageModel>> = flow{
        try{
            emit(Resource.Loading<WebImageModel>())
            val webImageModel = homeRepository.getUser(userID = userID).toWebImageModel()
            emit(Resource.Success<WebImageModel>(webImageModel))
        } catch (e : HttpException) {
            emit(Resource.Error<WebImageModel>(message = e.localizedMessage ?: "An unexpected error happen, try again later"))
        } catch (e : IOException) {
            emit(Resource.Error<WebImageModel>(message = e.localizedMessage ?: "Error happen, check your internet connection"))
        }
    }
}