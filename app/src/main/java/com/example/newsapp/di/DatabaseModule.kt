package com.example.newsapp.di

import android.content.Context
import androidx.room.Room
import com.example.newsapp.db.NewsDatabase
import com.example.newsapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideDatabase(@ApplicationContext context:Context):NewsDatabase{
        return Room.databaseBuilder(
            context,
            NewsDatabase::class.java,
            Constants.DATABASE_NAME)
            .build()
    }
}