import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers


fun main() {
    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=146"))
        .build()
    val response = client
        .send(request, BodyHandlers.ofString())

    val jason = response.body()
    println(jason)



    val meuJogo = Jogo("Batman: Arkham Asylum Game of the Year Edition",
        "https:\\/\\/cdn.cloudflare.steamstatic.com\\/steam\\/apps\\/35140\\/capsule_sm_120.jpg?t=1681938587")

    println(meuJogo)

    val novoJogo = Jogo()


}