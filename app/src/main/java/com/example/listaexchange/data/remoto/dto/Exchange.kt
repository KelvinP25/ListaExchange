package com.example.listaexchange.data.remoto.dto

data class Exchange(
    val name: String = "",
    val description: String? = null,
    val active: Boolean = false,
    val last_update: String = "",
)
