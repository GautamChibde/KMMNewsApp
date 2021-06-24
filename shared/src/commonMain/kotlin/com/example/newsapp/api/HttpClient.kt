package com.example.newsapp.api

import com.example.newsapp.model.Article
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*

class NewsAppHttpClient(): NewsApi {

    private val httpClient = HttpClient(CIO) {

        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

        engine {
            requestTimeout = 100_000
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

    private fun HttpRequestBuilder.buildUrl(path: String, parameters: List<Pair<String, String>>) {
        url {
            takeFrom("https://newsapi.org/v2/")
            encodedPath = path
        }
        parameter("apiKey", "49b9880188a443898d903121afa46e13")
        parameters.forEach {
            parameter(it.first, it.second)
        }
    }

    override suspend fun getTopHeadLines(): List<Article> {
        return httpClient.get<List<Article>>() {
            buildUrl(path = "top-headlines", listOf(Pair("country", "us")))
        }
    }
}