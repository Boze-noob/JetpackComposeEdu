package com.applid.gym.domain.use_cases.home

import com.applid.gym.common.Resource
import com.applid.gym.data.api.dto.home.toDiscoverWorkout
import com.applid.gym.domain.models.home.DiscoverWorkout
import com.applid.gym.domain.repositories.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetDiscoverWorkoutsUsaCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    operator fun invoke() : Flow<Resource<List<DiscoverWorkout>>> = flow {
        try {
            emit(Resource.Loading<List<DiscoverWorkout>>())
            val discoverWorkouts = homeRepository.getDiscoverWorkouts().map { it.toDiscoverWorkout() }
            emit(Resource.Success<List<DiscoverWorkout>>(discoverWorkouts))
        } catch(e : HttpException) {
            emit(Resource.Error<List<DiscoverWorkout>>(message = e.localizedMessage ?: "An unexpected error happen, try again later"))
        } catch (e : IOException) {
            emit(Resource.Error<List<DiscoverWorkout>>(message = e.localizedMessage ?: "Error happen, check your internet connection"))
        }
    }
}