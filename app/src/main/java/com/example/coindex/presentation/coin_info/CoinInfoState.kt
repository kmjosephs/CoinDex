package com.example.coindex.presentation.coin_info

import com.example.coindex.domain.model.CoinInfo

data class CoinInfoState (
    val isLoading: Boolean = false,
    val coin: CoinInfo? = null,
    val error: String = ""
)
