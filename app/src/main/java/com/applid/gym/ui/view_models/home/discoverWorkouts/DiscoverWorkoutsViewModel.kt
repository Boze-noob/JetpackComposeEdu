package com.applid.gym.ui.view_models.home.discoverWorkouts

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applid.gym.common.Resource
import com.applid.gym.domain.use_cases.home.GetDiscoverWorkoutsUsaCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class DiscoverWorkoutsViewModel @Inject constructor(
    private val getDiscoverWorkoutsUsaCase: GetDiscoverWorkoutsUsaCase,
) : ViewModel() {
    private val _state = mutableStateOf(DiscoverWorkoutsState())
    val state: State<DiscoverWorkoutsState> = _state

    fun onEvent(event: DiscoverWorkoutsEvent) {
        when (event) {
            is DiscoverWorkoutsEvent.Init -> {
                getDiscoverWorkouts()
            }
        }
    }

    private fun getDiscoverWorkouts() {
        getDiscoverWorkoutsUsaCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = DiscoverWorkoutsState(discoverWorkouts = result.data)
                }
                is Resource.Error -> {
                    _state.value = DiscoverWorkoutsState(
                        error = result.message ?: "An unexpected error happen"
                    )
                }
                is Resource.Loading -> {
                    _state.value = DiscoverWorkoutsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}