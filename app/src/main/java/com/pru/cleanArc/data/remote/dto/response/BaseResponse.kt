package com.pru.cleanArc.data.remote.dto.response

data class BaseResponse<T>(
    val isError: Boolean?,
    val message: String?,
    val returnValue: T?
)