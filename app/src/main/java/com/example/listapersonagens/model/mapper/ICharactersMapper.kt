package com.example.listapersonagens.model.mapper

import com.example.listapersonagens.model.response.Character

interface ICharactersMapper<in T> {
    fun transform(apiCharacters: List<T>): List<Character>
}