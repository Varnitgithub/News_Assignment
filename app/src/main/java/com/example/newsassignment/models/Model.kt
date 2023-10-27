package com.example.newsassignment.models

data class Model(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)