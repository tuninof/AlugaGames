package br.com.tunino.alugames.principal

import br.com.tunino.alugames.modelo.Gamer
import br.com.tunino.alugames.modelo.Jogo
import br.com.tunino.alugames.servicos.ConsumoApi
import br.com.tunino.alugames.utilitario.transformarIdade
import java.util.*


fun main() {

    val leitura = Scanner(System.`in`)

    val gamer = Gamer.criarGamer(leitura)

    println("Cadastro concluído com sucesso! Dados do gamer: ")
    println(gamer)
println("Idade do Gamer:" + gamer.dataNascimento?.transformarIdade())

    

    do {
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

            gamer.jogosBuscados.add(meuJogo)
        }

       println("Deseja buscar um novo jogo? S/N: ")
        val resposta = leitura.nextLine()


    }while (resposta.equals("s",true))

    println("Jogos buscados: ")
    println(gamer.jogosBuscados)

    println("Jogos ordenados por título:")
    gamer.jogosBuscados.sortBy {
        it?.titulo
    }

    gamer.jogosBuscados.forEach {
        println("Título: " + it?.titulo)
    }

    val jogosFiltrados = gamer.jogosBuscados.filter {
        it?.titulo?.contains("batman", true) ?: false
    }
    println("\n")
    println("Jogos Filtrados: ")
    println(jogosFiltrados)

    println("Deseja excluir algum jogo da lista original? S/N ")
    val opcao = leitura.nextLine()
    if (opcao.equals("s", true)) {
        println("\n")
        println(gamer.jogosBuscados)
        println("Informe a posição do jogo que deseja excluir:")
        val posicao = leitura.nextInt()
        gamer.jogosBuscados.removeAt(posicao)

        println(gamer.jogosBuscados)
    }

    println("Busca finalizada com sucesso!")

}