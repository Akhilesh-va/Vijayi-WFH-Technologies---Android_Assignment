package com.example.cryptocurrencyappmvvm.data.remote

import com.example.cryptocurrencyappmvvm.data.remote.dto.CoinDetailsDto
import com.example.cryptocurrencyappmvvm.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaAPI {
    @GET("coins")
    suspend fun  getCoins():List<CoinDto>

    @GET("coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailsDto


}