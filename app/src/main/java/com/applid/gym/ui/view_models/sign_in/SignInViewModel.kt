package com.applid.gym.ui.view_models.sign_in

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.applid.gym.common.Constants
import com.applid.gym.common.Resource
import com.applid.gym.domain.models.sign_in.SignInModel
import com.applid.gym.domain.use_cases.common.GetJWTUseCase
import com.applid.gym.domain.use_cases.common.PostJWTUseCase
import com.applid.gym.domain.use_cases.sign_in.SignInUserUseCase
import com.applid.gym.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUserUseCase: SignInUserUseCase,
    private val postJWTUseCase: PostJWTUseCase,
    private val getJWTUseCase: GetJWTUseCase
) : ViewModel() {
    private val _state = mutableStateOf(SignInState())
    val state: State<SignInState> = _state

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent  = _uiEvent.receiveAsFlow()

    var email by mutableStateOf("")
    var password by mutableStateOf("")

    fun onEvent(event : SignInEvent) {
        when(event) {
            is SignInEvent.SignIn -> {
                viewModelScope.launch {
                    if(email.isEmpty() || password.isEmpty()) {
                        sendUiEvent(UiEvent.ShowSnackBar(
                            message = "Please fill all fields!"
                        ))
                        return@launch
                    }
                    signIn(SignInModel(email = email, password = password))
                }
            }
            is SignInEvent.OnEmailChange -> {
                email = event.email
            }
            is SignInEvent.OnPasswordChange -> {
                password = event.password
            }
            is SignInEvent.OnForgotPassword -> {
                //TODO add
            }
        }
    }

    private fun signIn(signInModel : SignInModel) {
        signInUserUseCase(signInModel = signInModel).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = SignInState(signInModel = signInModel)
                    storeJWT(jwt = _state.value.signInModel?.token!!)
                }
                is Resource.Error -> {
                    val errorMessage = result.message ?: "An unexpected error happen"
                    _state.value = SignInState(
                        error = errorMessage
                    )
                    viewModelScope.launch {
                        sendUiEvent(UiEvent.ShowSnackBar(
                            message = errorMessage
                        ))
                        return@launch
                    }
                }
                is Resource.Loading -> {
                    _state.value = SignInState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun storeJWT(jwt : String) {
        val key = stringPreferencesKey(Constants.DATASTORE_JWT)
        viewModelScope.launch {
            postJWTUseCase(jwt = jwt, key = key).onEach { result ->
                if (result is Resource.Error) {
                 storeJWT(jwt)
                } else {
                    getJWTUseCase(key = key).onEach {
                        if(it is Resource.Success) {
                            println("This is your jwt from data store--------")
                            println(it.data)
                        }
                    }
                }
            }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}