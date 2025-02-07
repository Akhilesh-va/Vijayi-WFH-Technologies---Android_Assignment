package com.example.cryptocurrencyappmvvm.di

import androidx.lifecycle.SavedStateHandle
import com.example.cryptocurrencyappmvvm.data.remote.CoinPaprikaAPI

import com.example.cryptocurrencyappmvvm.domain.repository.CoinRepository
import com.example.cryptocurrencyappmvvm.domain.repository.CoinRepositoryImplementation
import com.example.cryptocurrencyappmvvm.domain.use_case.get_coin.GetCoinUseCase
import com.example.cryptocurrencyappmvvm.domain.use_case.get_coins.GetCoinsUseCase
import com.example.cryptocurrencyappmvvm.presentation.coin_list.CoinListViewModel

import com.plcoding.cryptocurrencyappyt.presentation.coin_detail.CoinDetailViewModel
import org.koin.core.module.dsl.viewModel

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {

    // Provide Retrofit instance
    single {
        Retrofit.Builder()
            .baseUrl("https://api.coinpaprika.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Provide API instance
    single<CoinPaprikaAPI> { get<Retrofit>().create(CoinPaprikaAPI::class.java) }

    // Provide Repository Implementation
    single<CoinRepository> { CoinRepositoryImplementation(get()) }

    // Provide Use Cases
    single { GetCoinsUseCase(get()) } // ✅ Registering GetCoinsUseCase
    single { GetCoinUseCase(get()) }  // ✅ Registering GetCoinUseCase

    // Provide CoinListViewModel
    viewModel { CoinListViewModel(get(), get()) }

    // Provide CoinDetailViewModel
    viewModel { (savedStateHandle: SavedStateHandle) ->
        CoinDetailViewModel(get(), get(), savedStateHandle) // ✅ Pass both dependencies
    }

}
