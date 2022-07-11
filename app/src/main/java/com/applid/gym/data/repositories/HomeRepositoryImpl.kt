package com.applid.gym.data.repositories

import com.applid.gym.data.api.Api
import com.applid.gym.data.api.dto.home.BasicInfoDto
import com.applid.gym.data.api.dto.home.DiscoverWorkoutDto
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
}