package com.applid.gym.ui.view_models.home.appBar

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applid.gym.common.Resource
import com.applid.gym.domain.use_cases.common.GetProfileImageUseCase
import com.applid.gym.ui.view_models.home.discoverWorkouts.DiscoverWorkoutsEvent
import com.applid.gym.ui.view_models.home.discoverWorkouts.DiscoverWorkoutsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AppBarViewModel @Inject constructor(
    private val getProfileImageUseCase: GetProfileImageUseCase,
) : ViewModel() {
    private val _state = mutableStateOf(AppBarState())
    val state: State<AppBarState> = _state

    fun onEvent(event: AppBarEvent) {
        when (event) {
            is AppBarEvent.Init -> {
                getProfileImage(event.userId)
            }
        }
    }

    private fun getProfileImage(userID : Int) {
        getProfileImageUseCase(userID = userID).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = AppBarState(webImageModel = result.data)
                }
                is Resource.Error -> {
                    _state.value = AppBarState(
                        error = result.message ?: "An unexpected error happen"
                    )
                }
                is Resource.Loading -> {
                    _state.value = AppBarState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}