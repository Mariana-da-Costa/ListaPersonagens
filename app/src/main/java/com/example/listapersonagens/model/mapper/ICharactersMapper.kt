package com.example.listapersonagens.model.mapper

interface ICharactersMapper<in T> {
    fun transform(apiCharacters: List<T>): List<com.example.listapersonagens.model.domain.Character>
}