package org.example.commonclient

import io.ktor.client.engine.*
import io.ktor.client.engine.cio.*

actual fun engine(): HttpClientEngineFactory<HttpClientEngineConfig> = CIO