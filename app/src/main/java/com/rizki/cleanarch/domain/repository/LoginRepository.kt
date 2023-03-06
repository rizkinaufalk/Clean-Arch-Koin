package com.rizki.cleanarch.domain.repository

import com.rizki.cleanarch.domain.model.LoginRequest
import com.rizki.cleanarch.domain.model.LoginResponse

interface LoginRepository {

    suspend fun doLogin(loginRequest: LoginRequest?): LoginResponse
}