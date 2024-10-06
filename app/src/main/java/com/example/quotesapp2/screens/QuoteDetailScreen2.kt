package com.example.quotesapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.quotesapp2.models.Quote

@Composable
fun QuoteDetailScreen2(quote: Quote) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.radialGradient(
                    colors = listOf(Color.White, Color.LightGray)
                )
            )
    ) {
        Card(elevation = CardDefaults.cardElevation(4.dp), modifier = Modifier.padding(32.dp)) {
            Column(verticalArrangement = Arrangement.Center, modifier = Modifier.padding(18.dp)) {
                // Display quote details
                Text(text = quote.quote, style = MaterialTheme.typography.headlineMedium)
                Spacer(Modifier.height(16.dp))
                Text(text = quote.author, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}