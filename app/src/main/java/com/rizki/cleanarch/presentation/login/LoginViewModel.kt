package com.rizki.cleanarch.presentation.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rizki.cleanarch.domain.model.ApiError
import com.rizki.cleanarch.domain.model.LoginRequest
import com.rizki.cleanarch.domain.model.LoginResponse
import com.rizki.cleanarch.domain.usecase.DoLoginUseCase
import com.rizki.cleanarch.domain.usecase.base.UseCaseResponse

class LoginViewModel constructor(private val doLoginUseCase: DoLoginUseCase) : ViewModel() {

    val postsData = MutableLiveData<LoginResponse>()
    val showProgressbar = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()

    fun doLogin(loginRequest: LoginRequest) {
        doLoginUseCase.invoke(
            viewModelScope, loginRequest,
            object : UseCaseResponse<LoginResponse> {
                override fun onSuccess(result: LoginResponse) {
                    postsData.postValue(result)
                    showProgressbar.value = false
                }

                override fun onError(apiError: ApiError?) {
                    messageData.value = apiError?.getErrorMessage()
                    showProgressbar.value = false
                }
            },
        )
    }
}