package com.rizki.cleanarch.domain.usecase

import com.rizki.cleanarch.domain.model.LoginRequest
import com.rizki.cleanarch.domain.model.LoginResponse
import com.rizki.cleanarch.domain.repository.LoginRepository
import com.rizki.cleanarch.domain.usecase.base.UseCase

class DoLoginUseCase constructor(
    private val loginRepository: LoginRepository
) : UseCase<LoginResponse, LoginRequest>() {

    override suspend fun run(params: LoginRequest?): LoginResponse {
        return loginRepository.doLogin(params)
    }

}