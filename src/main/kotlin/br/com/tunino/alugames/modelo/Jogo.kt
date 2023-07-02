package br.com.tunino.alugames.modelo

data class Jogo(
    val titulo: String,
    val capa: String
) {

    var descricao:String? = null
    override fun toString(): String {
        return "meu br.com.tunino.alugames.modelo.Jogo: \n" +
                "titulo: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao \n"
    }


}