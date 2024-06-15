package com.example.newsapp.di

import com.example.newsapp.api.ApiService
import com.example.newsapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun providesBaseUrl():String{
        return Constants.BASE_URL
    }

    @Provides
    fun providesInterceptor():HttpLoggingInterceptor{
        return HttpLoggingInterceptor()
    }

    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor):OkHttpClient{
        val okHttpClient = OkHttpClient.Builder()
            .apply {
                callTimeout(30,TimeUnit.SECONDS)
                connectTimeout(30,TimeUnit.SECONDS)
                readTimeout(30,TimeUnit.SECONDS)
                writeTimeout(30,TimeUnit.SECONDS)
                addInterceptor(httpLoggingInterceptor)
                    .build()
            }.build()
        return okHttpClient
    }

    @Provides
    fun provideGsonConvertFactory():Converter.Factory{
        return GsonConverterFactory.create()
    }

    @Provides
    fun provideRetrofitBuilder():Retrofit{
        return Retrofit.Builder()
            .baseUrl(providesBaseUrl())
            .client(provideOkHttpClient(providesInterceptor()))
            .addConverterFactory(provideGsonConvertFactory())
            .build()
    }

    @Provides
    fun provideApiService():ApiService{
        return provideRetrofitBuilder()
            .create(ApiService::class.java)
    }


}