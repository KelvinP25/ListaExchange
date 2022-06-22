package com.example.listaexchange.data.remoto.dto

data class ExchangeListaState(
    val isLoading: Boolean = false,
    val exchanges: List<Exchange> = emptyList(),
    val error: String = ""
)

