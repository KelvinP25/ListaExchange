package com.example.listaexchange

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.listaexchange.data.remoto.dto.Exchange
import com.example.listaexchange.ui.theme.Exchange.ExchangeScreen
import com.example.listaexchange.ui.theme.ListaExchangeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListaExchangeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ExchangeScreen()
                }
            }
        }
    }
}

@Composable
fun ExchangeItem(
    exch: Exchange,
    onClick: (Exchange) -> Unit
) {
    Row(modifier = Modifier
        .fillMaxSize()
        .clickable { onClick(exch) }
        .padding(16.dp)
    ) {
        Text(
            text = "${exch.name}",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "${exch.description}",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "${exch.active} (${exch.last_update})",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = if(exch.active) "Activo" else "Inactivo",
            color = if(exch.active) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(Alignment.CenterVertically)
        )

    }

}