package com.example.listaexchange.data.remoto

import com.example.listaexchange.data.remoto.dto.Exchange
import retrofit2.http.GET

interface ExchangeApi {
    @GET("/v1/exchanges")
    suspend fun getExchange(): List<Exchange>
}