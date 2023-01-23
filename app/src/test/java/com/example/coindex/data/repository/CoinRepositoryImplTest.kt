package com.example.coindex.data.repository

import com.example.coindex.data.remote.CoinApi
import com.example.coindex.data.remote.dto.CoinDto
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mock
import org.mockito.MockitoAnnotations

//I tried testing with both Junit and Mockito, but I couldn't get it to work in time
class CoinRepositoryImplTest {

        @Mock
         lateinit var coinApi: CoinApi

        private lateinit var coinRepository: CoinRepositoryImpl

        @BeforeEach
        fun setUp() {
            MockitoAnnotations.initMocks(this)
            coinRepository = CoinRepositoryImpl(coinApi)
        }
        @Test

        suspend fun `getCoins() calls coinApi`(){
            val coins = listOf(CoinDto(
                id = "1",
                isActive = true,
                isNew = true,
                name = "name", rank = 1,
                symbol = "symbol",
                type = "type"))
            coinRepository.getCoins()
            assertEquals(coins, coinRepository.getCoins())
        }

    @Test
    suspend fun `getCoinById() calls coinApi`() {
        val coin = CoinDto(
            id ="1",
            isActive = true,
            isNew = true,
            name = "name",
            rank = 1,
            symbol = "symbol",
            type = "type"
        )
        val result = coinRepository.getCoinById("1")
        assertEquals(coin, result)

    }
}

// Old Junit testing code
// For CoinRepositoryImpl(CoinApi) I receive an error that says
// "class Classifier 'CoinApi' does not have a companion object,
// and thus must be initialized here", but coinApi is an interface
// this has been raised in the issue tracker on Jetbrains
// https://youtrack.jetbrains.com/issue/KT-39673

//internal class CoinRepositoryImplTest {
//    private val repository = CoinRepositoryImpl(CoinApi)
//
//    @Test
//    suspend fun getCoins() {
//        val coins = repository.getCoins()
//        assertNotNull(coins)
//        assertTrue(coins.isNotEmpty())
//    }
//
//    @Test
//    suspend fun getCoinById() {
//        val id = "1"
//        val expectedCoin = CoinDto(
//            id = id,
//            isActive = true,
//            isNew = false,
//            name = "Bitcoin",
//            rank = 1,
//            symbol = "BTC",
//            type = "coin"
//        )
//        val actualCoin = repository.getCoinById(id)
//        assertEquals(expectedCoin, actualCoin)
//    }
//}