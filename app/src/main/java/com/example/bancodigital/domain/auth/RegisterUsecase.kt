package com.example.bancodigital.domain.auth

import com.example.bancodigital.data.repository.auth.AuthFIrebaseDataSourceImpl

class RegisterUsecase(
    private val authFIrebaseDataSourceImpl: AuthFIrebaseDataSourceImpl
) {

    suspend operator fun invoke(
        nome: String,
        email: String,
        telefone: String,
        password: String
    ) {
        return authFIrebaseDataSourceImpl.register(nome, email, telefone, password)
    }

}