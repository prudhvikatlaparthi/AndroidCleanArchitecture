package com.pru.cleanArc.presentation.ui.authentication.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pru.cleanArc.data.remote.dto.payload.AuthenticationPayloadDto
import com.pru.cleanArc.domain.useCases.LoginUseCase
import com.pru.cleanArc.presentation.ui.authentication.AuthenticationState
import com.pru.cleanArc.utils.MyPreferences
import com.pru.cleanArc.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val myPreferences: MyPreferences
) : ViewModel() {

    private val _emailTextController = mutableStateOf("")
    val emailTextController: State<String>
        get() = _emailTextController

    fun updateEmail(text: String) {
        _emailTextController.value = text
    }

    private var _passwordTextController = mutableStateOf("")
    val passwordTextController: State<String>
        get() = _passwordTextController

    fun updatePassword(text: String) {
        _passwordTextController.value = text
    }

    fun validateFields(): Boolean {
        return true
    }

    private val _state = mutableStateOf(AuthenticationState())
    val state: State<AuthenticationState> = _state

    fun loginUser() {
        if (validateFields()) {
            val registerPayloadDto = AuthenticationPayloadDto(
                email = _emailTextController.value,
                password = _passwordTextController.value,
                confirm_password = _passwordTextController.value,
            )
            viewModelScope.launch(Dispatchers.IO) {
                loginUseCase.invoke(registerPayloadDto).collect { result ->
                    when (result) {
                        is Resource.Success -> {
                            result.data?.let { id ->
                                myPreferences.setLoginUserID(id)
                                _state.value = AuthenticationState(userID = id)
                            }
                        }
                        is Resource.Error -> {
                            _state.value = AuthenticationState(
                                error = result.message ?: "An unexpected error occurred"
                            )
                        }
                        is Resource.Loading -> {
                            _state.value = AuthenticationState(isLoading = true)
                        }
                    }
                }
            }
        }
    }
}