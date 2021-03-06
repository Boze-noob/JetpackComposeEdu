package com.applid.gym.data.repositories

import com.applid.gym.data.api.Api
import com.applid.gym.data.api.dto.UserDto
import com.applid.gym.data.api.dto.home.BasicInfoDto
import com.applid.gym.data.api.dto.home.DiscoverWorkoutDto
import com.applid.gym.data.api.dto.home.UserProgressPercentageDto
import com.applid.gym.domain.models.sign_up.SignUpModel
import com.applid.gym.domain.repositories.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val api: Api
) : HomeRepository {

    override suspend fun getBasicInfo(subscriptionID: Int): BasicInfoDto {
        return api.getHomeBasicInfo(subscriptionID = subscriptionID)
    }

    override suspend fun getDiscoverWorkouts(): List<DiscoverWorkoutDto> {
        return api.getDiscoverWorkouts()
    }

    override suspend fun getUser(userID : Int): UserDto {
        return api.getUser(userID = userID)
    }

    override suspend fun getUserProgressPercentage(exerciseID : Int) : UserProgressPercentageDto {
        return api.getUserProgressPercentage(exerciseID = exerciseID)
    }
}