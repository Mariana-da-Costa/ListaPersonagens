package com.example.listapersonagens.datasource.interfaces

interface UserRemoteDataSource {
    fun login(email: String, pw: String): Boolean
}