package com.example.listapersonagens.ui.utils

import java.lang.Thread.State

interface ConectionState {
    fun stable()
    fun error()
}

class Stable : ConectionState {
    override fun stable() {
        println("Conexão estável")
    }

    override fun error() {
        println("Falha na conexão")
    }

}

class Listen : ConectionState {
    override fun stable() {
        println("Conexão estável")
    }

    override fun error() {
        println("Falha na conexão")
    }
}

class Conection : ConectionState {
    private var state : Listen = Listen()

    override fun stable() {
        state.stable()
    }

    override fun error() {
        state.error()
    }
}

fun main() {
    val connection = Conection()
    connection.stable()
    connection.error()
}

//Um pequeno exemplo utilizando o State como padrão comportamental que podemos utilizar
//para definir estados de rede, quando fizermos requisições