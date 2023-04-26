package com.example.listapersonagens.datasource.impl

import com.example.listapersonagens.datasource.interfaces.UserRemoteDataSource
import com.example.listapersonagens.network.service.LoginService
import javax.inject.Inject

class UserRemoteDataSourceImpl @Inject constructor(private val loginService: LoginService) :
    UserRemoteDataSource {
    override fun login(email: String, pw: String): Boolean {
        return loginService.login(email, pw)
    }
}