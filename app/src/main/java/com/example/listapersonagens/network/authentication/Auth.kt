package com.example.listapersonagens.network.authentication

import com.example.listapersonagens.model.domain.User
import com.example.listapersonagens.network.service.LoginService

object Auth {
    fun loginProvider(): LoginService {
        return object : LoginService {
            override fun login(email: String, password: String): Boolean {
                return registeredUsers.any { it.email == email && it.password == password }
            }
        }
    }

    val registeredUsers = listOf(
        User("teste1@gmail.com", "123"),
        User("teste2@gmail.com", "456")
    )

    object Backend : IAuthenticatorLogin {
        private val registeredUsers = listOf(
            User("teste3@gmail.com", "789"),
            User("teste4@gmail.com", "123")
        )

        override fun login(email: String, password: String): Boolean =
            registeredUsers.any { it.email == email && it.password == password }
    }

    object Firebase : IAuthenticatorLogin {
        private val registeredUsers = listOf(
            User("teste1@gmail.com", "123"),
            User("teste2@gmail.com", "456")
        )

        override fun login(email: String, password: String): Boolean =
            registeredUsers.any { it.email == email && it.password == password }
    }
}