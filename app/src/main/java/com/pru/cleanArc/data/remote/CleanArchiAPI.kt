package com.pru.cleanArc.data.remote

import com.pru.cleanArc.data.remote.dto.payload.AuthenticationPayloadDto
import com.pru.cleanArc.data.remote.dto.response.BaseResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface CleanArchiAPI {

    @POST("/register")
    suspend fun register(@Body authenticationPayloadDto: AuthenticationPayloadDto): BaseResponse<Int>

    @POST("/login")
    suspend fun login(@Body authenticationPayloadDto: AuthenticationPayloadDto): BaseResponse<Int>
}