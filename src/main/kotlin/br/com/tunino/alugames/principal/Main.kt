package br.com.tunino.alugames.principal

import br.com.tunino.alugames.modelo.Jogo
import br.com.tunino.alugames.servicos.ConsumoApi
import java.util.*


fun main() {

    val leitura = Scanner(System.`in`)
    println("Digite um código de jogo para buscar:")
    val busca = leitura.nextLine()

    val endereco = "https://www.cheapshark.com/api/1.0/games?id=$busca"

    val buscaApi = ConsumoApi()
    val informacaoJogo = buscaApi.buscaJogo(endereco)

    var meuJogo: Jogo? = null

    val resultado = runCatching {
        meuJogo = Jogo(
            informacaoJogo.info.title,
            informacaoJogo.info.thumb
        )

    }

    resultado.onFailure {
        println("Jogo inexistente. Tente outro código.")
    }




    resultado.onSuccess {
        println("Deseja inserir uma descrição personalizada? S/N:")
        val opcao = leitura.nextLine()

        if (opcao.equals("s", true)) {
            println("Insira a descrição personalizada do jogo:")
            val descricaoPersonalizada = leitura.nextLine()
            meuJogo?.descricao = descricaoPersonalizada
        } else {
            meuJogo?.descricao = meuJogo?.titulo
        }

        println(meuJogo)
    }

    resultado.onSuccess {
        println("Busca finalizada com sucesso!")
    }

}