package com.example.cryptochecker

import com.example.cryptochecker.models.RandomResponse
import retrofit2.http.GET

interface ServiceApi {

    @GET("quotes/random")
    suspend fun getRandomQuote(): RandomResponse
}