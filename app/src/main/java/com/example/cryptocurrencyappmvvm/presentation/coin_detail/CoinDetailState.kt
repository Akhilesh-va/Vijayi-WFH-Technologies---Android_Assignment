package com.example.cryptocurrencyappmvvm.presentation.coin_detail


import com.example.cryptocurrencyappmvvm.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading : Boolean=false,
    val coin: CoinDetail?=null,
    val error : String = ""
)
