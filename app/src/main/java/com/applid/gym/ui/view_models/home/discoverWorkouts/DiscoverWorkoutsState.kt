package com.applid.gym.ui.view_models.home.discoverWorkouts

import com.applid.gym.domain.models.home.DiscoverWorkout

data class DiscoverWorkoutsState(
    val isLoading : Boolean = false,
    val discoverWorkouts : List<DiscoverWorkout>? = null,
    val error : String = ""
)