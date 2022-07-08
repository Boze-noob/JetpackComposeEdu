package com.applid.gym.data.repositories

import android.util.Log
import com.applid.gym.data.api.Api
import com.applid.gym.data.api.dto.home.BasicInfoDto
import com.applid.gym.domain.models.home.BasicInfo
import com.applid.gym.domain.repositories.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val api: Api
) : HomeRepository {

    override suspend fun getBasicInfo(subscriptionID: Int): BasicInfoDto {
        return api.getHomeBasicInfo(subscriptionID = subscriptionID)
    }
}