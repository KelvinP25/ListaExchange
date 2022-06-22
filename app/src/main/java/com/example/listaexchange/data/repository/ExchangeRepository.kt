package com.example.listaexchange.data.repository

import com.example.listaexchange.data.remoto.ExchangeApi
import com.example.listaexchange.data.remoto.dto.Exchange
import com.example.listaexchange.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ExchangeRepository @Inject constructor(
    private val api: ExchangeApi
){
    fun getExchanges(): Flow<Resource<List<Exchange>>> = flow {
        try {
            emit(Resource.Loading())
            val exchange = api.getExchange()
            emit(Resource.Success(exchange))
        } catch (e: HttpException) {
            emit(Resource.Error(e.message ?: "Error Occurred!"))
        } catch (e: IOException) {
            emit(Resource.Error(e.message ?: "Verificar conexión a internet"))
        }
    }
}