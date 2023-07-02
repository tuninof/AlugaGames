package br.com.tunino.alugames.modelo

import java.lang.IllegalArgumentException
import kotlin.random.Random

data class Gamer(var nome: String, var email: String) {
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank()){
                criaridInterno()
            }
        }
    var idInterno: String? = null
        private set

    constructor(nome: String, email: String, dataNascimento: String, usuario: String) : this(nome, email) {
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        criaridInterno()
    }

    init {
        if (nome.isNullOrBlank()){
            throw IllegalArgumentException("Nome em branco")
        }
        this.email = validarEmail()
    }

    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }

    private fun criaridInterno() {
        val numero = Random.nextInt(10000)
        val tag = String.format("%04d", numero)

        idInterno = "$usuario#$tag"


    }

    private fun validarEmail():String{
        val regex = Regex("""^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$""")
        if (regex.matches(email)){
            this.email = email
            return email
        } else{
            throw IllegalArgumentException("Email invalido")
        }
    }


}
