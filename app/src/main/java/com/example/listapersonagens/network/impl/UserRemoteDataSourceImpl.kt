package com.example.listapersonagens.network.impl

import com.example.listapersonagens.network.interfaces.UserRemoteDataSource
import com.example.listapersonagens.network.login.LoginService
import javax.inject.Inject

class UserRemoteDataSourceImpl @Inject constructor(private val loginService: LoginService) :
    UserRemoteDataSource {
    override fun login(email: String, pw: String): Boolean {
        return loginService.login(email, pw)
    }
}