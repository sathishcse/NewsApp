package com.example.newsapp.models

data class NewsMeta(
    val found: Int,
    val limit: Int,
    val page: Int,
    val returned: Int
)