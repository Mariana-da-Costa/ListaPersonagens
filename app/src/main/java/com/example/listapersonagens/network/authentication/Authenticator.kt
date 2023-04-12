package com.example.listapersonagens.network.authentication

import com.example.listapersonagens.model.domain.User

object Authenticator {
    object Backend : IAuthenticatorLogin {
        private val registeredUsers = listOf(
            User("teste3@gmail.com", "789"),
            User("teste4@gmail.com", "123")
        )

        override fun login(email: String, password: String): Boolean =
            registeredUsers.any { it.email == email && it.password == password }
    }

    object Firebase : IAuthenticatorLogin {
        private val registeredUsers = listOf(
            User("teste1@gmail.com", "123"),
            User("teste2@gmail.com", "456")
        )

        override fun login(email: String, password: String): Boolean =
            registeredUsers.any { it.email == email && it.password == password }
    }
}

//Usando o princípio da Segregação de Interfaces, separamos a função login dentro de uma interface
//e implementamos a mesma nos objetos, elas continuam dependendo apenas de métodos que de fato irão
//utilizar.
//Melhora a manutenabilidade. Implementa o pilar da herança quando herda os métodos da interface.
//Quando não declaramos os detalhes do método na interface, e sim os detalhes são aplicados na
//implementação do método, garantimos o Princípio da Inversão de Dependência.