package com.example.listapersonagens.repository

import com.example.listapersonagens.model.User

interface UserRepository {
    fun login(email: String, pw: String): Boolean
    fun getUser(): User
}