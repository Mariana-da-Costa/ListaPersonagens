package com.example.listapersonagens.network.service

import com.example.listapersonagens.model.response.DisneyCharactersResult
import retrofit2.http.GET

interface DisneyService {
    @GET("characters")
    suspend fun getCharacters(): DisneyCharactersResult
}