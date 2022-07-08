package com.applid.gym.ui.view_models.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applid.gym.common.Constants
import com.applid.gym.common.Resource
import com.applid.gym.domain.use_cases.home.GetBasicInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class BasicInfoViewModel @Inject constructor(
    private val getBasicInfoUseCase : GetBasicInfoUseCase,
    savedStateHandle : SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(BasicInfoState())
    val state : State<BasicInfoState> = _state

    fun onEvent(event : BasicInfoEvent){
        when(event) {
            is BasicInfoEvent.Init -> {
                getBasicInfo(event.subscriptionID)
            }
        }
    }

    //TODO delete this if fun onEvent works properly
    init {
        savedStateHandle.get<Int>(Constants.PARAM_SUBSCRIPTION_ID)?.let { subscriptionID ->
            getBasicInfo(subscriptionID = subscriptionID)
        }
    }

    private fun getBasicInfo(subscriptionID : Int) {
        getBasicInfoUseCase(subscriptionID = subscriptionID).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = BasicInfoState(basicInfo = result.data)
                }
                is Resource.Error -> {
                    _state.value = BasicInfoState(
                        error = result.message ?: "An unexpected error happen"
                    )
                }
                is Resource.Loading -> {
                    _state.value = BasicInfoState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}