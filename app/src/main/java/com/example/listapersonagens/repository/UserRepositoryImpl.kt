package com.example.listapersonagens.repository

import com.example.listapersonagens.network.interfaces.UserLocalDataSource
import com.example.listapersonagens.network.interfaces.UserRemoteDataSource
import com.example.listapersonagens.model.User
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