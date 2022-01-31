package org.example.aclient

import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@JsExport
@Serializable
data class Todo(val id: Int, val userId: Int, val title: String, val completed: Boolean)

class TodosApi(private val client: HttpClient) {
    suspend fun findById(id: Int): Todo {
        return client.get("/todos/$id")
    }
}
