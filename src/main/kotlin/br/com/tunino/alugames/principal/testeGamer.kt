package br.com.tunino.alugames.principal

import br.com.tunino.alugames.modelo.Gamer

fun main(){

    val gamer1 = Gamer("Fábio", "fabio@email.com")
    println(gamer1)

    val gamer2 = Gamer("Felipe", "felipe@email.com", "23/08/2014", "lipe")
    println(gamer2)

    gamer1.let {
        it.dataNascimento = "28/07/83"
        it.usuario = "tunino"


    }

    println(gamer2.idInterno)



    println(gamer1)

    gamer1.usuario = "Fabio"

    println(gamer1)

    val gamer3 = Gamer("Bianca", "bianca@email.com")

    println(gamer3)

    gamer3.usuario = "bibis"

    println(gamer3)

}