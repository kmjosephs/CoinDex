package com.example.coindex.data.remote

import com.example.coindex.data.remote.dto.CoinDto
import com.example.coindex.data.remote.dto.CoinInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

// CoinPaprika API
interface CoinApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinInfoDto
}
