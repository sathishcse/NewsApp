package com.example.newsapp.utils

sealed class ViewStatus<T>(
    val data:T?=null,
    val error:Throwable?=null
) {
    class Success<T>(data:T) :ViewStatus<T>(data)
    class Error(val message:String):ViewStatus<Nothing>()
    class Loading:ViewStatus<Nothing>()
}