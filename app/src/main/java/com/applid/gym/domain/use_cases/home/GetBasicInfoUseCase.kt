package com.applid.gym.domain.use_cases.home

import android.util.Log
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
    operator fun invoke(subscriptionID : Int) : Flow<Resource<BasicInfo>> = flow {
        try {
            emit(Resource.Loading<BasicInfo>())
            val basicInfo = homeRepository.getBasicInfo(subscriptionID = subscriptionID).toBasicInfo()
            emit(Resource.Success<BasicInfo>(basicInfo))
        } catch (e : HttpException) {
            emit(Resource.Error<BasicInfo>(message = e.localizedMessage ?: "An unexpected error happen, try again later"))
        } catch (e : IOException) {
            emit(Resource.Error<BasicInfo>(message = e.localizedMessage ?: "Error happen, check your internet connection"))
        }
    }
}