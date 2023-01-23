package com.example.coindex.data.repository

import com.example.coindex.data.remote.CoinApi
import com.example.coindex.data.remote.dto.CoinDto
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

// in this class I receive an error that says
// "class Classifier 'CoinApi' does not have a companion object,
// and thus must be initialized here", but coinApi is an interface
// this has been raised in the issue tracker on Jetbrains
// https://youtrack.jetbrains.com/issue/KT-39673

internal class CoinRepositoryImplTest {
    private val repository = CoinRepositoryImpl(CoinApi)

    @Test
    suspend fun getCoins() {
        val coins = repository.getCoins()
        assertNotNull(coins)
        assertTrue(coins.isNotEmpty())
    }

    @Test
    suspend fun getCoinById() {
        val id = "1"
        val expectedCoin = CoinDto(
            id = id,
            isActive = true,
            isNew = false,
            name = "Bitcoin",
            rank = 1,
            symbol = "BTC",
            type = "coin"
        )
        val actualCoin = repository.getCoinById(id)
        assertEquals(expectedCoin, actualCoin)
    }
}