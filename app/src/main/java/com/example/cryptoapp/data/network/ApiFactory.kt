package com.example.cryptoapp.data.network

import com.example.cryptoapp.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.API_BASE_URL)
        .build()

    val apiService = retrofit.create(ApiService::class.java)
}