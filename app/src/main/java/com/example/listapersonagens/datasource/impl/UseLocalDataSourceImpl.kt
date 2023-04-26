package com.example.listapersonagens.datasource.impl

import com.example.listapersonagens.datasource.interfaces.UserLocalDataSource
import com.example.listapersonagens.model.domain.User
import com.example.listapersonagens.network.authentication.Auth
import javax.inject.Inject

class UseLocalDataSourceImpl @Inject constructor() :
    UserLocalDataSource {
    override fun getUser(): User {
        return Auth.registeredUsers.last()
    }
}