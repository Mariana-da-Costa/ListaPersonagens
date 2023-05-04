package com.example.listapersonagens.repository

import com.example.listapersonagens.network.service.DisneyService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DisneyRepository {
    fun returnDisney(): DisneyService {
        val retrofitDisney: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.disneyapi.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofitDisney.create(DisneyService::class.java)
    }
}