package com.example.coindex.di

import com.example.coindex.common.Constants
import com.example.coindex.data.remote.CoinApi
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module@InstallIn(SingletonComponent::class)
@Singleton
object AppModule {
    fun provideCoinApi(): CoinApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)
    }
}
