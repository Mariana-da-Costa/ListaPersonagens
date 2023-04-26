package com.example.listapersonagens.datasource.interfaces

import com.example.listapersonagens.model.domain.User

interface UserLocalDataSource {
    fun getUser(): User
}