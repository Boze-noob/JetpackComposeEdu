package com.applid.gym.ui.view_models.home.userProgressPercentage

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applid.gym.common.Resource
import com.applid.gym.domain.use_cases.home.GetUserProgressPercentageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UserProgressPercentageViewModel @Inject constructor(
    private val getUserProgressPercentageUseCase: GetUserProgressPercentageUseCase,
) : ViewModel() {
    private val _state = mutableStateOf(UserProgressPercentageState())
    val state: State<UserProgressPercentageState> = _state

    fun onEvent(event: UserProgressPercentageEvent) {
        when (event) {
            is UserProgressPercentageEvent.Init -> {
                getUserProgressPercentage(event.exerciseID)
            }
        }
    }

    private fun getUserProgressPercentage(exerciseID : Int) {
        getUserProgressPercentageUseCase(exerciseID = exerciseID).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = UserProgressPercentageState(userProgressPercentage = result.data)
                }
                is Resource.Error -> {
                    _state.value = UserProgressPercentageState(
                        error = result.message ?: "An unexpected error happen"
                    )
                }
                is Resource.Loading -> {
                    _state.value = UserProgressPercentageState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}