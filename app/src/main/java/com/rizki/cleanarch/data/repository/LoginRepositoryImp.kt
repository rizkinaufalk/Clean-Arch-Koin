package com.rizki.cleanarch.data.repository

import com.rizki.cleanarch.data.source.remote.LoginService
import com.rizki.cleanarch.domain.model.LoginRequest
import com.rizki.cleanarch.domain.model.LoginResponse
import com.rizki.cleanarch.domain.repository.LoginRepository

class LoginRepositoryImp(private val apiService: LoginService) : LoginRepository {

    override suspend fun doLogin(loginRequest: LoginRequest?): LoginResponse {
        return apiService.doLogin(loginRequest)
    }
}