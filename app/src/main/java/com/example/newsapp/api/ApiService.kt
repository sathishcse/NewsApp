package com.example.newsapp.api

import com.example.newsapp.models.NewsModel
import com.example.newsapp.utils.Constants
import retrofit2.http.GET

interface ApiService {
    @GET(Constants.TOP_NEWS)
    suspend fun getTopNews():NewsModel
}