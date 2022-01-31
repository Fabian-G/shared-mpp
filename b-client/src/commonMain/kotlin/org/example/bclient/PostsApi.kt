package org.example.bclient

import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
data class Post(val id: Int, val userId: Int, val title: String, val body: String)

class PostsApi(private val client: HttpClient) {
    suspend fun findById(id: Int): Post {
        return client.get("/posts/$id")
    }
}