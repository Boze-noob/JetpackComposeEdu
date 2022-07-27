package com.applid.gym.data.api

import com.applid.gym.data.api.dto.UserDto
import com.applid.gym.data.api.dto.home.BasicInfoDto
import com.applid.gym.data.api.dto.home.DiscoverWorkoutDto
import com.applid.gym.data.api.dto.home.UserProgressPercentageDto
import com.applid.gym.domain.models.sign_in.SignInModel
import com.applid.gym.domain.models.sign_up.SignUpModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Api {

    @GET("home/get/basicInfo/{subscriptionID}")
    suspend fun getHomeBasicInfo(@Path("subscriptionID") subscriptionID: Int): BasicInfoDto

    @GET("home/get/discoverWorkout")
    suspend fun getDiscoverWorkouts() : List<DiscoverWorkoutDto>

    @GET("user/get/{userID}")
    suspend fun getUser(@Path("userID") userID: Int) : UserDto

    @GET("home/get/userProgress/{exerciseID}")
    suspend fun getUserProgressPercentage(@Path("exerciseID") exerciseID : Int) : UserProgressPercentageDto

    @POST("user/post/signUp")
    suspend fun postSignUp(@Body signUpModel : SignUpModel) : SignUpModel

    @POST("user/post/login")
    suspend fun postSignIn(@Body signInModel : SignInModel) : SignInModel
}