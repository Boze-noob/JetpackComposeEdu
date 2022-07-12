package com.applid.gym.data.api

import com.applid.gym.data.api.dto.UserDto
import com.applid.gym.data.api.dto.home.BasicInfoDto
import com.applid.gym.data.api.dto.home.DiscoverWorkoutDto
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("home/get/basicInfo/{subscriptionID}")
    suspend fun getHomeBasicInfo(@Path("subscriptionID") subscriptionID: Int): BasicInfoDto

    @GET("home/get/discoverWorkout")
    suspend fun getDiscoverWorkouts() : List<DiscoverWorkoutDto>

    @GET("get/user")
    suspend fun getUser() : UserDto
}