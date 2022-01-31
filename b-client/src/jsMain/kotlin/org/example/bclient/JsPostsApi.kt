package org.example.bclient

import io.ktor.client.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.promise
import kotlin.js.Promise

/**
 * Just a wrapper around PostsApi that exposes promises instead of suspend functions
 */
@JsExport
class JsPostsApi(private val client: HttpClient) {
    private val api = PostsApi(client)
    private val requestsScope = CoroutineScope(Dispatchers.Default)

    fun findById(id: Int): Promise<Post> = requestsScope.promise {
        api.findById(id)
    }
}