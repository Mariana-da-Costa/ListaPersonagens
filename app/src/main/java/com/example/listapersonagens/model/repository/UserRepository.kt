package com.example.listapersonagens.model.repository

import com.example.listapersonagens.model.domain.User

interface UserRepository {
    fun login(email: String, pw: String): Boolean
    fun getUser(): User
}