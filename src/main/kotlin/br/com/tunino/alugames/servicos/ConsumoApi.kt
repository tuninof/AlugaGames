package br.com.tunino.alugames.servicos

import br.com.tunino.alugames.modelo.InfoJogo
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoApi {
    fun buscaJogo(id: String):InfoJogo{
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(id))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

        return meuInfoJogo

    }

}