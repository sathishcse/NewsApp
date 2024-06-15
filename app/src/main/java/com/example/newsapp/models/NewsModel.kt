package com.example.newsapp.models

data class NewsModel(
    val data: List<NewsDataDto>,
    val meta: NewsMeta
)