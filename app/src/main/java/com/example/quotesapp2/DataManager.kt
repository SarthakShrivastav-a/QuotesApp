package com.example.quotesapp2

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotesapp2.models.Quote
import com.google.gson.Gson


object DataManager {
        // Initially, the data array is empty
        var data = emptyArray<Quote>()
        var isLoaded = mutableStateOf(false)

        // Function to load the JSON file from the assets folder
        fun loadAssetsFromFile(context: Context) {
            try {
                val inputStream = context.assets.open("quotes.json")
                val size: Int = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                val json = String(buffer, Charsets.UTF_8)

                // Parse JSON
                val gson = Gson()
                data = gson.fromJson(json, Array<Quote>::class.java)
                isLoaded.value = true
            } catch (e: Exception) {
                e.printStackTrace()
                isLoaded.value = false // Prevent app from crashing if there's an error
            }
        }

}