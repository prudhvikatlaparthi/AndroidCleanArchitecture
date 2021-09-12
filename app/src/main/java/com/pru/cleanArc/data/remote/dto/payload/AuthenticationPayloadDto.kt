package com.pru.cleanArc.data.remote.dto.payload

data class AuthenticationPayloadDto(
    val confirm_password: String? = null,
    val email: String,
    val name: String? = null,
    val password: String
)