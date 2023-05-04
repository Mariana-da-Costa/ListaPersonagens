package com.example.listapersonagens.network.interfaces

interface UserRemoteDataSource {
    fun login(email: String, pw: String): Boolean
}