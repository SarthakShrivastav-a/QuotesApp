package com.example.quotesapp2.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.quotesapp2.R
import com.example.quotesapp2.models.Quote


@Composable
fun QuoteListScreen(data: Array<Quote>, onClick: (Quote) -> Unit) {
    Column {
        Text(
            text = "Quotes App",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp, 24.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.headlineMedium,
        )
        QuoteList(data = data, onClick = onClick)
    }
}

@Composable
fun QuoteList(data: Array<Quote>, onClick: (Quote) -> Unit) {
    LazyColumn {
        items(data) { quote ->
            QuoteListItem(quote = quote) {
                onClick(quote)
            }
        }
    }
}

@Composable
fun QuoteListItem(quote: Quote, onClick: () -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
        modifier = Modifier
            .padding(10.dp)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "Quote Image",
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .size(42.dp)
                    .background(Color.Black)
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Column {
                Text(
                    text = quote.quote,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.4f)
                        .height(1.dp)
                        .background(Color.Black)
                        .padding(vertical = 8.dp)
                )
                Text(
                    text = quote.author,
                    textAlign = TextAlign.End,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Light
                )
            }
        }
    }
}