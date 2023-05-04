package com.example.listapersonagens.view.fragment

class MenuItem(var nome: String)

internal interface Iterator {
    operator fun hasNext(): Boolean
    operator fun next(): Any?
}

class MenuIterator(private var itens: Array<MenuItem?>) : Iterator {
    private var posicao = 0
    override fun next(): Any? {
        val menuItem = itens[posicao]
        posicao++
        return menuItem
    }

    override fun hasNext(): Boolean {
        return !(posicao >= itens.size || itens[posicao] == null)
    }
}

object MostraMenu {
    @JvmStatic
    fun main(args: Array<String>) {
        val menuItens = arrayOfNulls<MenuItem>(4)
        menuItens[0] = MenuItem("Opção 1")
        menuItens[1] = MenuItem("Opção 2")
        for (i in menuItens.indices) {
            println(menuItens[i]!!.nome)
        }
    }
}

//Um pequeno exemplo de como podemos utilizar o padrão comportamental Iterator, para criar novos
// itens de menu no nosso projeto.