package com.example.newsapp.api

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*

fun getKtorHttpClient() = HttpClient {

    install(JsonFeature) {
        serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })
    }

    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                print("message $message")
            }
        }

        level = LogLevel.INFO
    }
}

fun HttpRequestBuilder.buildUrl(path: String, parameters: List<Pair<String, String>>) {
    url {
        takeFrom("https://newsapi.org/")
        encodedPath = path
    }
    parameter("apiKey", "49b9880188a443898d903121afa46e13")
    parameters.forEach {
        parameter(it.first, it.second)
    }
}