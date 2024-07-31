package com.example.bancodigital.data.repository.auth

interface AuthFIrebaseDataSource {

    suspend fun login(
        email: String,
        password: String
    )

    suspend fun register(
        nome: String,
        email: String,
        telefone: String,
        password: String
    )

    suspend fun recover(
        email: String
    )
}