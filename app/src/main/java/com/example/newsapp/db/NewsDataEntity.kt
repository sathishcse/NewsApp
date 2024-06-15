package com.example.newsapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.newsapp.utils.Constants

@Entity(tableName = Constants.TABLE_NAME)
data class NewsDataEntity(
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
    @PrimaryKey
    val uuid: String
)