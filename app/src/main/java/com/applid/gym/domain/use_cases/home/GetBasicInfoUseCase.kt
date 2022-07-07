package com.applid.gym.domain.use_cases.home

import com.applid.gym.common.Resource
import com.applid.gym.data.api.dto.home.toBasicInfo
import com.applid.gym.domain.models.home.BasicInfo
import com.applid.gym.domain.repositories.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetBasicInfoUseCase @Inject constructor(
    private val homeRepository: HomeRepository
){
    operator fun invoke(userID : String) : Flow<Resource<BasicInfo>> = flow {
        try {
            emit(Resource.Loading())
            val basicInfo = homeRepository.getBasicInfo(userID = userID).toBasicInfo()
            emit(Resource.Success(basicInfo))
        } catch (e : HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error happen, try again later"))
        } catch (e : IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error happen, check your internet connection"))
        }
    }
}