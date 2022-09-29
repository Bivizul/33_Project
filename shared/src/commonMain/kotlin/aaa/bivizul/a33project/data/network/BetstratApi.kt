package aaa.bivizul.a33project.data.network

import aaa.bivizul.a33project.domain.util.Betstratcon.BETSTRATBASEURL
import aaa.bivizul.a33project.domain.util.Betstratcon.BETSTRATGURL
import aaa.bivizul.a33project.domain.util.Betstratcon.BETSTRATITEMURL
import aaa.bivizul.a33project.domain.model.Betstrat
import aaa.bivizul.a33project.domain.model.BetstratItem
import aaa.bivizul.a33project.domain.model.Betstratg
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.http.ContentType.Application.Json
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class BetstratApi {

    val betstrathc = HttpClient(CIO) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.INFO
        }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
//        install(HttpTimeout) {
//            val timeout = 30000L
//            connectTimeoutMillis = timeout
//            requestTimeoutMillis = timeout
//            socketTimeoutMillis = timeout
//        }
    }

    private fun HttpRequestBuilder.betstratbase(path: String) {
        url {
            takeFrom(BETSTRATBASEURL)
            encodedPath = path
        }
    }

    suspend fun getBetstratItem(): List<BetstratItem> {
        val getbetstratitemurl = BETSTRATITEMURL
        val betstrathr = betstrathc.get { betstratbase(getbetstratitemurl) }
        val getbetstratitembody = betstrathr.body<List<BetstratItem>>()
        return getbetstratitembody
    }

    suspend fun getBetstratg(betstrat: Betstrat): Betstratg {
        val getbetstraturl = BETSTRATGURL
        val betstrathr = betstrathc.post {
            betstratbase(getbetstraturl)
            contentType(Json)
            setBody(betstrat)
        }
        val getbetstratbody = betstrathr.body<Betstratg>()
        return getbetstratbody
    }

}