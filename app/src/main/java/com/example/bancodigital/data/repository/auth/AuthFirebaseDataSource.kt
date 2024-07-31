package com.example.bancodigital.data.repository.auth

import com.example.bancodigital.data.model.User

interface AuthFirebaseDataSource {

    suspend fun login(
        email: String,
        password: String
    )

    suspend fun register(
        user: User
    ): User

    suspend fun recover(
        email: String
    )
}