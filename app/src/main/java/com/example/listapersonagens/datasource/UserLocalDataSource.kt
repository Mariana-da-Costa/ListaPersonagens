package com.example.listapersonagens.datasource

import com.example.listapersonagens.model.domain.User

interface UserLocalDataSource {
    fun getUser(): User
}