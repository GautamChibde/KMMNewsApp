package com.example.newsapp.model

enum class NewsCategories(val value: String) {
    Business("business"),
    Entertainment("entertainment"),
    General("general"),
    Health("health"),
    Science("science"),
    Sports("sports"),
    Technology("technology");

    companion object {
        private val map = NewsCategories.values().associateBy(NewsCategories::value)
        fun from(type: String) = map[type]
    }
}