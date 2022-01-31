package org.example.commonclient

import io.ktor.client.engine.*
import io.ktor.client.engine.js.*

actual fun engine(): HttpClientEngineFactory<HttpClientEngineConfig> = Js