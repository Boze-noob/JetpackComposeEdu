package com.applid.gym.ui.view_models.signUp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applid.gym.common.Resource
import com.applid.gym.domain.models.sign_up.SignUpModel
import com.applid.gym.domain.use_cases.common.SignUpUserUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
    private val signUpUserUseCase: SignUpUserUseCase
) : ViewModel() {
    private val _state = mutableStateOf(SignUpState())
    val state: State<SignUpState> = _state

    fun onEvent(event: SignUpEvent) {
        when (event) {
            is SignUpEvent.SignUp -> {
                signUp(event.signUpModel)
            }
        }
    }

    private fun signUp(signUpModel : SignUpModel) {
        signUpUserUseCase(signUpModel = signUpModel).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = SignUpState(signUpModel = signUpModel)
                }
                is Resource.Error -> {
                    _state.value = SignUpState(
                        error = result.message ?: "An unexpected error happen"
                    )
                }
                is Resource.Loading -> {
                    _state.value = SignUpState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}