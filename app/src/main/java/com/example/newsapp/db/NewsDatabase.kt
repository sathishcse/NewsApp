package com.example.newsapp.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NewsDataEntity::class], version = 1)
abstract class NewsDatabase : RoomDatabase(){
    abstract fun newsDao() : NewsDao
}