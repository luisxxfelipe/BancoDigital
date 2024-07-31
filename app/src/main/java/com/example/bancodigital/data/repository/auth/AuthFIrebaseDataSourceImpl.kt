package com.example.bancodigital.data.repository.auth

import com.google.firebase.database.FirebaseDatabase

class AuthFIrebaseDataSourceImpl(
    firebaseDatabase: FirebaseDatabase
) : AuthFIrebaseDataSource {

    override suspend fun login(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun register(nome: String, email: String, telefone: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun recover(email: String) {
        TODO("Not yet implemented")
    }

}