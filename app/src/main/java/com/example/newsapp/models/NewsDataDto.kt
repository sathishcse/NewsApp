package com.example.newsapp.models

import com.google.gson.annotations.SerializedName

data class NewsDataDto(
    @SerializedName("description")
    val description: String?,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("keywords")
    val keywords: String?,
    @SerializedName("language")
    val language: String?,
    @SerializedName("locale")
    val locale: String?,
    @SerializedName("published_at")
    val publishedAt: String?,
    @SerializedName("relevance_score")
    val relevanceScore: String?,
    @SerializedName("snippet")
    val snippet: String?,
    @SerializedName("source")
    val source: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("uuid")
    val uuid: String
)