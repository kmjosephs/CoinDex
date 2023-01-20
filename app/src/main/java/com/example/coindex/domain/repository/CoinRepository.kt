package com.example.coindex.domain.repository

import com.example.coindex.data.remote.dto.CoinDto
import com.example.coindex.data.remote.dto.CoinInfoDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinInfoDto
}