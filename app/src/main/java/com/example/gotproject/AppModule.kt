package com.example.gotproject

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun getAppDatabase(context: Context): AppDatabase {
        return AppDatabase.getAppDBInstance(context)
    }

    @Provides
    @Singleton
    fun getAppDao(appDatabase: AppDatabase): AppDao {
        return appDatabase.getAppDao()
    }

    @Provides
    @Singleton
    fun getRetroServiceInstance(retrofit: Retrofit): RetroServiceInterface {
        return retrofit.create(RetroServiceInterface::class.java)
    }

    @Provides
    @Singleton
    fun getRetroInstance(): Retrofit {
        val BASE_URL = "https://anapioficeandfire.com/api/"
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}