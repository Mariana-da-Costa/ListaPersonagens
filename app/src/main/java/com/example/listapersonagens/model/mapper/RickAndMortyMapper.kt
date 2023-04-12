package com.example.listapersonagens.model.mapper

import com.example.listapersonagens.model.api.RickyAndMortyCharacter
import com.example.listapersonagens.model.domain.Character

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