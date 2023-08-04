package com.example.daggermvvm.di

import com.example.daggermvvm.retrofit.ApiGet
import com.example.daggermvvm.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class NetworkModule {
    /**
     * Jitne bhi Provides method honge vo hm yha pe likhenge
     */

    @Singleton
    @Provides
    fun providesRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiData(retrofit: Retrofit):ApiGet{
        return retrofit.create(ApiGet::class.java)
    }
}