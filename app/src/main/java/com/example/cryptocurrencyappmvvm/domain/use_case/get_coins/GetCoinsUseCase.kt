package com.example.cryptocurrencyappmvvm.domain.use_case.get_coins

import com.example.cryptocurrencyappmvvm.common.Resource
import com.example.cryptocurrencyappmvvm.data.remote.dto.toCoin
import com.example.cryptocurrencyappmvvm.domain.model.Coin
import com.example.cryptocurrencyappmvvm.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException


class GetCoinsUseCase(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow{
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))

        }
        catch (e:HttpException){
            emit(Resource.Error(e.localizedMessage?:"An unexpected error has occured"))

        }
        catch (e:IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))

        }

    }
}