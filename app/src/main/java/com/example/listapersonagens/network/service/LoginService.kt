package com.example.listapersonagens.network.service

import retrofit2.http.GET

interface LoginService {
    @GET("login")
    fun login(email: String, password: String): Boolean
}