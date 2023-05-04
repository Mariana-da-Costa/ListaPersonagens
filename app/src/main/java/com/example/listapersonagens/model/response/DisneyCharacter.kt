package com.example.listapersonagens.model.response

import com.example.listapersonagens.model.domain.Disney
import com.example.listapersonagens.model.domain.ICharacterType

data class DisneyCharacter(val name: String, val image: String) : ICharacterType by Disney