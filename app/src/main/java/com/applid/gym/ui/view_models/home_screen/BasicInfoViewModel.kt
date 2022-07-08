package com.applid.gym.ui.view_models.home_screen

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
import com.applid.gym.ui.view_models.home_screen.BasicInfoState
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
                getBasicInfo(event.userID)
            }
        }
    }

    //TODO delete this if fun onEvent works properly
    init {
        savedStateHandle.get<String>(Constants.PARAM_USER_ID)?.let { userID ->
            getBasicInfo(userID = userID)
        }
    }

    private fun getBasicInfo(userID : String) {
        getBasicInfoUseCase(userID = userID).onEach { result ->
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