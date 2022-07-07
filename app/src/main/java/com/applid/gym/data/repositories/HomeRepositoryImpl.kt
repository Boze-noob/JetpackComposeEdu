package com.applid.gym.data.repositories

import com.applid.gym.data.api.Api
import com.applid.gym.data.api.dto.home.BasicInfoDto
import com.applid.gym.domain.repositories.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val api: Api
) : HomeRepository {

    override suspend fun getBasicInfo(userID: String): BasicInfoDto {
        return api.getHomeBasicInfo(userId = userID)
    }


}