package com.example.coindex.data.map

import com.example.coindex.data.remote.dto.CoinDto
import com.example.coindex.data.remote.dto.CoinInfoDto
import com.example.coindex.domain.model.Coin
import com.example.coindex.domain.model.CoinInfo

    fun CoinDto.toCoin(): Coin {
        return Coin (
            id = id,
            isActive = isActive,
            name = name,
            rank = rank,
            symbol = symbol
        )
    }
    fun CoinInfoDto.toCoinInfo(): CoinInfo {
        return CoinInfo (
            coinId = id,
            name = name,
            description = description,
            symbol = symbol,
            rank = rank,
            isActive = isActive,
            tags = tags.map { it.name },
            team = team
        )
    }
