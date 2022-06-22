package com.example.listaexchange.ui.theme.Exchange

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listaexchange.data.remoto.dto.ExchangeListaState
import com.example.listaexchange.data.repository.ExchangeRepository
import com.example.listaexchange.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ExchangeViewModel @Inject constructor(
    private val exchangeRepository: ExchangeRepository
) : ViewModel() {
    private var _state = mutableStateOf(ExchangeListaState())
    val state: State<ExchangeListaState> = _state

    init {
        exchangeRepository.getExchanges().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = ExchangeListaState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = ExchangeListaState(exchanges = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = ExchangeListaState(error = result.message ?: "Error desconocido")
                }
            }
        }.launchIn(viewModelScope)
    }
}
