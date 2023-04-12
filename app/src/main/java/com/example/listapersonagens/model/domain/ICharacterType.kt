package com.example.listapersonagens.model.domain

import androidx.annotation.ColorRes

interface ICharacterType {
    val title: String
    val imageUrl: String
    @get:ColorRes
    val colorRes: Int
}