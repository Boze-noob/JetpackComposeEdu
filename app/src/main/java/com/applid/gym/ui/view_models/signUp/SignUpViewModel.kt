package com.applid.gym.ui.view_models.signUp

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applid.gym.common.Resource
import com.applid.gym.domain.models.sign_up.SignUpModel
import com.applid.gym.domain.use_cases.common.SignUpUserUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import androidx.compose.runtime.setValue
import com.applid.gym.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUserUseCase: SignUpUserUseCase
) : ViewModel() {
    private val _state = mutableStateOf(SignUpState())
    val state: State<SignUpState> = _state

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent  = _uiEvent.receiveAsFlow()

    var username by mutableStateOf("")
    var password by mutableStateOf("")
    var confirmPassword by mutableStateOf("")
    var email by mutableStateOf("")


    fun onEvent(event: SignUpEvent) {
        when (event) {
            is SignUpEvent.SignUp -> {
                viewModelScope.launch {
                    if(username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                        sendUiEvent(UiEvent.ShowSnackBar(
                            message = "Please fill all fields!"
                        ))
                        return@launch
                }
                    if(password != confirmPassword){
                        sendUiEvent(UiEvent.ShowSnackBar(
                            message = "Passwords do not match!"
                        ))
                        return@launch
                    }
                    signUp(SignUpModel(username = username, password = password, email = email))
                }
            }
            is SignUpEvent.OnUsernameChange -> {
                username = event.username
            }
            is SignUpEvent.OnPasswordChange -> {
                password = event.password
            }
            is SignUpEvent.OnConfirmPasswordChange -> {
                confirmPassword = event.confirmPassword
            }
            is SignUpEvent.OnEmailChange -> {
                email = event.email
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

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

}