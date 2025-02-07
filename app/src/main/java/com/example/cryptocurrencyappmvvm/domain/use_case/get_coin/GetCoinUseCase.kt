package com.example.cryptocurrencyappmvvm.domain.use_case.get_coin

import com.example.cryptocurrencyappmvvm.common.Resource
import com.example.cryptocurrencyappmvvm.data.remote.dto.toCoin
import com.example.cryptocurrencyappmvvm.data.remote.dto.toCoinDetail
import com.example.cryptocurrencyappmvvm.domain.model.Coin
import com.example.cryptocurrencyappmvvm.domain.model.CoinDetail
import com.example.cryptocurrencyappmvvm.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException


class GetCoinUseCase(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow{
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))

        }
        catch (e:HttpException){
            emit(Resource.Error(e.localizedMessage?:"An unexpected error has occured"))

        }
        catch (e:IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))

        }

    }
}