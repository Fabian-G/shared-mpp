package org.example.commonclient

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.http.*
import kotlin.js.JsExport

expect fun engine(): HttpClientEngineFactory<HttpClientEngineConfig>

@JsExport
fun createClient(hostString: String): HttpClient {
    return HttpClient(engine()) {
        defaultRequest {
            url.apply {
                val defaultUrl = Url(hostString)
                protocol = defaultUrl.protocol
                host = defaultUrl.host
                port = defaultUrl.port
            }
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }
}