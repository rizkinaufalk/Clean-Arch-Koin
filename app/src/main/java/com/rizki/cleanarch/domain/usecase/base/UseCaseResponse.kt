package com.rizki.cleanarch.domain.usecase.base

import com.rizki.cleanarch.domain.model.ApiError

interface UseCaseResponse<Type> {

    fun onSuccess(result: Type)

    fun onError(apiError: ApiError?)
}

