package com.example.listapersonagens.network.authentication

interface IAuthenticatorLogin {
    fun login(email: String, password: String): Boolean
}