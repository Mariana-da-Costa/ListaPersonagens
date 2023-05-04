package com.example.listapersonagens.model.mapper

import com.example.listapersonagens.model.response.Character
import com.example.listapersonagens.model.response.RickyAndMortyCharacter

class RickAndMortyMapper : ICharactersMapper<RickyAndMortyCharacter> {
    override fun transform(apiCharacters: List<RickyAndMortyCharacter>): List<Character> {
        return apiCharacters.map {
            Character(
                name = it.name,
                imageUrl = it.image
            )
        }
    }
}