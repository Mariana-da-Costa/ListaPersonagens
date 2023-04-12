package com.example.listapersonagens.model.domain

import com.example.listapersonagens.R

//Antes
//enum class CharacterType(
//    val title: String,
//    val imageUrl: String,
//    @ColorRes val colorRes: Int,
//) {
//    DISNEY(
//        title = "Disney",
//        imageUrl = "https://icon-library.com/images/disney-icon-png/disney-icon-png-20.jpg",
//        colorRes = R.color.red_disney
//    ),
//    RICKY_AND_MORTY(
//        title = "Ricky And Morty",
//        imageUrl = "https://logosmarcas.net/wp-content/uploads/2022/01/Rick-And-Morty-Logo.png",
//        colorRes = R.color.blue_ricky_and_morty
//    )
//}

//Nessa classe utilizamos o Princípio do aberto/fechado e a Segregação de Interfaces
//assim, podemos criar objetos para cada tipo de personagem, implementando as características
//definidas pela interface, assim a classe também passa a extender.
//Segue o pilar da herança da POO por herdar os métodos da interface.

//Depois
object Disney : ICharacterType {
    override val title = "Disney"
    override val imageUrl = "https://icon-library.com/images/disney-icon-png/disney-icon-png-20.jpg"
    override val colorRes = R.color.red_disney
}

object RickAndMorty : ICharacterType {
    override val title = "Ricky And Morty"
    override val imageUrl =
        "https://logosmarcas.net/wp-content/uploads/2022/01/Rick-And-Morty-Logo.png"
    override val colorRes = R.color.blue_ricky_and_morty
}