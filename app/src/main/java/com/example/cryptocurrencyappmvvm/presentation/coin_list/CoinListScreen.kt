package com.example.cryptocurrencyappmvvm.presentation.coin_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController
import com.example.cryptocurrencyappmvvm.presentation.Screen
import com.example.cryptocurrencyappmvvm.presentation.coin_list.components.CoinListItem
import org.koin.viewmodel.getViewModelKey
import org.koin.androidx.compose.koinViewModel


@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel= koinViewModel()
){
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()
        .padding(0.dp, 50.dp, 0.dp, 0.dp)){
        LazyColumn(modifier=Modifier.fillMaxSize()){
            items(state.coins){ coin ->
                CoinListItem(coin = coin,
                    onItemClick = {
                        navController.navigate(Screen.CoinDetailScreen.route+"/${coin.id}")
                    })



            }
        }
        if(state.error.isNotBlank()){
            Text(
                text=state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

    }
}