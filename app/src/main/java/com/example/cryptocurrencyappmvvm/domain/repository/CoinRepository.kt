package com.example.cryptocurrencyappmvvm.domain.repository

import com.example.cryptocurrencyappmvvm.data.remote.dto.CoinDetailsDto
import com.example.cryptocurrencyappmvvm.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins():List<CoinDto>
    suspend fun getCoinById(coinId:String):CoinDetailsDto
}