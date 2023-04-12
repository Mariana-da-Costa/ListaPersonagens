package com.example.listapersonagens.model.mapper

import com.example.listapersonagens.model.domain.Character
import com.example.listapersonagens.model.api.DisneyCharacter

//Depois
//Aplicando o princípio da responsabilidade única, fazendo com que exista uma classe para cada
//mapper, cada uma responsável por uma api. Assim, também facilita a manutenabilidade, onde a
//alteração poderá ser feita sem impactar a outra API.
//Aplicando o princípio aberto/fechado, foi criada uma interface ICharactersMapper, onde cada classe
//poderá implementar essa interface que define o método para criar a lista de personagens.
//Também foi utilizado o Princípio da Segregação de Interfaces, ao criar a interface ICharactersMapper,
//as classes estão implementando apenas métodos que estão utilizando.
//Facilita a manutenção do código e usa os pilares de herança e polimorfismo, quando aplica os métodos
//da interface que permite transformar um objeto com as características de outro.

class DisneyMapper: ICharactersMapper<DisneyCharacter> {
    override fun transform(apiCharacters: List<DisneyCharacter>): List<Character> {
        return apiCharacters.map {
            Character(
                name = it.name,
                imageUrl = it.imageUrl
            )
        }
    }
}

//Antes
//@JvmName("toDisneyDomain")
//fun List<DisneyCharacter>.toDomain(): List<Character> {
//    return this.map {
//        Character(
//            name = it.name,
//            imageUrl = it.imageUrl
//        )
//    }
//}
//
//@JvmName("toRickyAndMortyDomain")
//fun List<RickyAndMortyCharacter>.toDomain(): List<Character> {
//    return this.map {
//        Character(
//            name = it.name,
//            imageUrl = it.image
//        )
//    }
//}