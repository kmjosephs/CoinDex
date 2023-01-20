package com.example.coindex.data.repository

import com.example.coindex.data.remote.CoinApi
import com.example.coindex.data.remote.dto.CoinDto
import com.example.coindex.data.remote.dto.CoinInfoDto
import com.example.coindex.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinApi: CoinApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return coinApi.getCoins()
    }
    override suspend fun getCoinById(coinId: String): CoinInfoDto {
        return coinApi.getCoinById(coinId)
    }
}
