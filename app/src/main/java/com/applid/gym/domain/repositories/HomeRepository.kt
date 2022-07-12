package com.applid.gym.domain.repositories

import com.applid.gym.data.api.dto.UserDto
import com.applid.gym.data.api.dto.home.BasicInfoDto
import com.applid.gym.data.api.dto.home.DiscoverWorkoutDto
import com.applid.gym.domain.models.User
import com.applid.gym.domain.models.home.BasicInfo

//Good to have for testing purposes
interface HomeRepository {

    suspend fun getBasicInfo(subscriptionID : Int) : BasicInfoDto
    suspend fun getDiscoverWorkouts() : List<DiscoverWorkoutDto>
    suspend fun getUser(userID : Int) : UserDto

}