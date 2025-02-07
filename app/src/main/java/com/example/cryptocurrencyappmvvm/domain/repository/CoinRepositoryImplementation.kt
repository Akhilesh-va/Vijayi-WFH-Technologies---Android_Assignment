package com.example.cryptocurrencyappmvvm.domain.repository

import com.example.cryptocurrencyappmvvm.data.remote.CoinPaprikaAPI
import com.example.cryptocurrencyappmvvm.data.remote.dto.CoinDetailsDto
import com.example.cryptocurrencyappmvvm.data.remote.dto.CoinDto


class CoinRepositoryImplementation(
    private val api: CoinPaprikaAPI
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> = api.getCoins()
    override suspend fun getCoinById(coinId: String): CoinDetailsDto = api.getCoinById(coinId)
}
