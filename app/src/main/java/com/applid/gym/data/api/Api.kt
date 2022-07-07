package com.applid.gym.data.api

import com.applid.gym.data.api.dto.home.BasicInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("/homeBasicInfo/{userId}")
    suspend fun getHomeBasicInfo(@Path("userId") userId: String): BasicInfoDto
}