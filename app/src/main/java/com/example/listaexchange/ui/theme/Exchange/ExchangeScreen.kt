package com.example.listaexchange.ui.theme.Exchange

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.listaexchange.ExchangeItem

@Composable
fun ExchangeScreen(viewModel: ExchangeViewModel = hiltViewModel()) {
    val state = viewModel.state.value

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.exchanges) { exchange ->
                ExchangeItem( exch = exchange, {})
            }
        }

        if (state.isLoading) {
            CircularProgressIndicator()
        }
    }

}