package com.pru.cleanArc.data.repository

import com.pru.cleanArc.data.remote.CleanArchiAPI
import com.pru.cleanArc.data.remote.dto.payload.AuthenticationPayloadDto
import com.pru.cleanArc.data.remote.dto.response.BaseResponse
import com.pru.cleanArc.domain.repository.CleanArchiRepository
import javax.inject.Inject

class CleanArchiRepositoryImp @Inject constructor(
    private val api: CleanArchiAPI
) : CleanArchiRepository {
    @Throws(Exception::class)
    override suspend fun register(authenticationPayloadDto: AuthenticationPayloadDto): BaseResponse<Int> {
        return api.register(authenticationPayloadDto = authenticationPayloadDto)
    }

    @Throws(Exception::class)
    override suspend fun login(authenticationPayloadDto: AuthenticationPayloadDto): BaseResponse<Int> {
        return api.login(authenticationPayloadDto = authenticationPayloadDto)
    }
}