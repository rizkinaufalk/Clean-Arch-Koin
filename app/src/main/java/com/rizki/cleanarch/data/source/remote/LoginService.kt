package com.rizki.cleanarch.data.source.remote

import com.rizki.cleanarch.domain.model.LoginRequest
import com.rizki.cleanarch.domain.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("/api/login")
    suspend fun doLogin(@Body loginRequest: LoginRequest?): LoginResponse  // TODO RK: Change function
}