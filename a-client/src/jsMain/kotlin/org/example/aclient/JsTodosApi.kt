package org.example.aclient

import io.ktor.client.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.promise
import kotlin.js.Promise

/**
 * Just a wrapper around TodosApi that exposes promises instead of suspend functions
 */
@JsExport
class JsTodosApi(private val client: HttpClient) {
    private val api = TodosApi(client)
    private val requestsScope = CoroutineScope(Dispatchers.Default)

    fun findById(id: Int): Promise<Todo> = requestsScope.promise {
        api.findById(id)
    }
}
