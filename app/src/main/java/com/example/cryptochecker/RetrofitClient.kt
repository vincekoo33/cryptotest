package com.example.cryptochecker

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    val webservice: ServiceApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://quote-garden.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ServiceApi::class.java)
    }
}