package com.example.cryptochecker

import android.util.Log
import androidx.lifecycle.liveData
import com.example.cryptochecker.models.RetrofitResult
import kotlinx.coroutines.delay

open class ServiceRepository(private val retrofitClient: RetrofitClient) {
    open suspend fun getRandomQuoteEveryMinute() = liveData {
        while (true) {
            try {
                Log.d("asdf", "getRandomQuoteEveryMinute")
                emit(RetrofitResult.success(retrofitClient.webservice.getRandomQuote()))
                delay(60000)
            } catch (exception: Exception) {
                emit(RetrofitResult.error(exception.toString(), null))
            }
        }
    }
}