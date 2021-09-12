package com.pru.cleanArc.presentation.ui.authentication

data class AuthenticationState(
    val isLoading: Boolean = false,
    val userID: Int = Int.MIN_VALUE,
    val error: String = ""
)