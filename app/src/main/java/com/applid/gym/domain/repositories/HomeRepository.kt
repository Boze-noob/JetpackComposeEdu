package com.applid.gym.domain.repositories

import com.applid.gym.data.api.dto.home.BasicInfoDto
import com.applid.gym.domain.models.home.BasicInfo

//Good to have for testing purposes
interface HomeRepository {

    suspend fun getBasicInfo(userID : String) : BasicInfoDto

}