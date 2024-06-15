package com.example.newsapp.repository

import androidx.room.withTransaction
import com.example.newsapp.api.ApiService
import com.example.newsapp.db.NewsDatabase
import com.example.newsapp.models.toEntity
import com.example.newsapp.models.toModel
import com.example.newsapp.utils.networkBoundResource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val apiService: ApiService,
    private val newsDB:NewsDatabase
) {

    private val newsDao = newsDB.newsDao()

    fun getAllNews() = networkBoundResource(
        query = {
            newsDao.getAllNews().map { data ->
                data.map { it.toModel() }
            }
        },
        fetch = {
            //delay(2000)
            apiService.getTopNews()
        },
        saveFetchResult = { data ->
            newsDB.withTransaction {
                newsDao.deleteAll()
                newsDao.insertNewsArticle(data.data.map { return@map it.toEntity() })
            }
        }
    )
}