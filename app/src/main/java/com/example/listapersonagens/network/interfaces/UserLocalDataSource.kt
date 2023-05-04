package com.example.listapersonagens.network.interfaces

import com.example.listapersonagens.model.User

interface UserLocalDataSource {
    fun getUser(): User
}