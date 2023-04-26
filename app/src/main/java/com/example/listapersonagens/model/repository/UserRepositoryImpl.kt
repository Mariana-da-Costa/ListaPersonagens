package com.example.listapersonagens.model.repository

import com.example.listapersonagens.datasource.interfaces.UserLocalDataSource
import com.example.listapersonagens.datasource.interfaces.UserRemoteDataSource
import com.example.listapersonagens.model.domain.User
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userLocalDataSource: UserLocalDataSource,
    private val userRemoteDataSource: UserRemoteDataSource,
) : UserRepository {

    override fun login(email: String, pw: String): Boolean {
        return userRemoteDataSource.login(email, pw)
    }

    override fun getUser(): User {
        return userLocalDataSource.getUser()
    }
}