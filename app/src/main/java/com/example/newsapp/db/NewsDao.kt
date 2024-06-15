package com.example.newsapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsapp.utils.Constants
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewsArticle(list:List<NewsDataEntity>)

    @Query("SELECT * FROM ${Constants.TABLE_NAME}")
    fun getAllNews():Flow<List<NewsDataEntity>>

    @Query("DELETE FROM ${Constants.TABLE_NAME}")
    suspend fun deleteAll()
}