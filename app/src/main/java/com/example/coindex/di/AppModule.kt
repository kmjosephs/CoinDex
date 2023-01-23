package com.example.coindex.di

import com.example.coindex.utils.Constants
import com.example.coindex.data.remote.CoinApi
import com.example.coindex.data.repository.CoinRepositoryImpl
import com.example.coindex.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCoinApi(): CoinApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(coinApi: CoinApi) : CoinRepository =
        CoinRepositoryImpl(coinApi)
}
