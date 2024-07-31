package com.example.bancodigital.domain.auth

import com.example.bancodigital.data.repository.auth.AuthFIrebaseDataSourceImpl

class LoginUsecase(
    private val authFIrebaseDataSourceImpl: AuthFIrebaseDataSourceImpl
) {

    suspend operator fun invoke(email: String, password: String) {
        return authFIrebaseDataSourceImpl.login(email, password)
    }

}