package com.example.listapersonagens.network.impl

import com.example.listapersonagens.network.interfaces.UserLocalDataSource
import com.example.listapersonagens.model.User
import com.example.listapersonagens.network.login.Auth
import javax.inject.Inject

class UseLocalDataSourceImpl @Inject constructor() :
    UserLocalDataSource {
    override fun getUser(): User {
        return Auth.registeredUsers.last()
    }
}