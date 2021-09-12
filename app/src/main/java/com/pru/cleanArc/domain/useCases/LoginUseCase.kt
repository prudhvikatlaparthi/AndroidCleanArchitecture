package com.pru.cleanArc.domain.useCases

import com.pru.cleanArc.data.remote.dto.payload.AuthenticationPayloadDto
import com.pru.cleanArc.domain.repository.CleanArchiRepository
import com.pru.cleanArc.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val cleanArchiRepository: CleanArchiRepository
) {
    operator fun invoke(authenticationPayloadDto: AuthenticationPayloadDto): Flow<Resource<Int>> =
        flow<Resource<Int>> {
            emit(Resource.Loading())
            kotlin.runCatching {
                cleanArchiRepository.login(authenticationPayloadDto)
            }.onSuccess { result ->
                if (result.isError == false) {
                    result.returnValue?.let { id ->
                        emit(Resource.Success(id))
                    }
                } else {
                    emit(Resource.Error(result.message ?: "Login is failed."))
                }
            }.onFailure {
                emit(Resource.Error(it.localizedMessage ?: "An unexpected error occurred"))
            }
        }
}