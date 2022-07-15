package com.applid.gym.domain.use_cases.home

import com.applid.gym.common.Resource
import com.applid.gym.data.api.dto.home.toUserProgressPercentage
import com.applid.gym.domain.models.home.UserProgressPercentage
import com.applid.gym.domain.repositories.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUserProgressPercentageUseCase @Inject constructor(
    private val homeRepository: HomeRepository
){
    operator fun invoke(exerciseID : Int) : Flow<Resource<UserProgressPercentage>> = flow {
        try {
            emit(Resource.Loading<UserProgressPercentage>())
            val userProgressPercentage = homeRepository.getUserProgressPercentage(exerciseID = exerciseID).toUserProgressPercentage()
            emit(Resource.Success<UserProgressPercentage>(userProgressPercentage))
        } catch (e : HttpException) {
            emit(Resource.Error<UserProgressPercentage>(message = e.localizedMessage ?: "An unexpected error happen, try again later"))
        } catch (e : IOException) {
            emit(Resource.Error<UserProgressPercentage>(message = e.localizedMessage ?: "Error happen, check your internet connection"))
        }
    }
}