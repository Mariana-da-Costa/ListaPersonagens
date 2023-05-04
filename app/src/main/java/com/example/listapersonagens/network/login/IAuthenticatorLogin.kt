package com.example.listapersonagens.network.login

interface IAuthenticatorLogin {
    fun login(email: String, password: String): Boolean
}