package com.pru.cleanArc.domain.repository

import com.pru.cleanArc.data.remote.dto.payload.AuthenticationPayloadDto
import com.pru.cleanArc.data.remote.dto.response.BaseResponse

interface CleanArchiRepository {
    @Throws(Exception::class)
    suspend fun register(authenticationPayloadDto: AuthenticationPayloadDto): BaseResponse<Int>

    @Throws(Exception::class)
    suspend fun login(authenticationPayloadDto: AuthenticationPayloadDto): BaseResponse<Int>
}