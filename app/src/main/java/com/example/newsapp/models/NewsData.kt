package com.example.newsapp.models

data class NewsData(
    val description: String?,
    val imageUrl: String?,
    val keywords: String?,
    val language: String?,
    val locale: String?,
    val publishedAt: String?,
    val relevanceScore: String?,
    val snippet: String?,
    val source: String?,
    val title: String?,
    val url: String?,
    val uuid: String
)