package com.example.quotesapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quotesapp.screens.QuoteDetailScreen2
import com.example.quotesapp2.models.Quote
import com.example.quotesapp2.screens.QuoteListScreen
import com.example.quotesapp2.ui.theme.QuotesApp2Theme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetsFromFile(applicationContext)
        }

        setContent {
            App()
            }
        }
    }
@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "quoteList") {

        composable("quoteList") {
            QuoteListScreen(data = DataManager.data) { quote ->
                navController.navigate("quoteDetail/${quote.quote}/${quote.author}")
            }
        }
        composable("quoteDetail/{quote}/{author}") { backStackEntry ->
            val quote = backStackEntry.arguments?.getString("quote") ?: ""
            val author = backStackEntry.arguments?.getString("author") ?: ""
            QuoteDetailScreen2(Quote(quote, author))
        }
    }
}