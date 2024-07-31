package com.example.bancodigital.domain.auth

import com.example.bancodigital.data.repository.auth.AuthFIrebaseDataSourceImpl

class RecoverUsecase(
    private val authFIrebaseDataSourceImpl: AuthFIrebaseDataSourceImpl
) {

    suspend operator fun invoke(email: String) {
        return authFIrebaseDataSourceImpl.recover(email)
    }

}