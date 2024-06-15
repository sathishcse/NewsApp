package com.example.newsapp.models

import com.example.newsapp.db.NewsDataEntity

fun NewsDataDto.toEntity() = NewsDataEntity(
    description = description,
    imageUrl = imageUrl,
    keywords = keywords,
    language = language,
    locale = locale,
    publishedAt = publishedAt,
    relevanceScore = relevanceScore,
    snippet = snippet,
    source = source,
    title = title,
    url = url,
    uuid = uuid
)

fun NewsDataEntity.toModel() = NewsData(
    description = description,
    imageUrl = imageUrl,
    keywords = keywords,
    language = language,
    locale = locale,
    publishedAt = publishedAt,
    relevanceScore = relevanceScore,
    snippet = snippet,
    source = source,
    title = title,
    url = url,
    uuid = uuid
)