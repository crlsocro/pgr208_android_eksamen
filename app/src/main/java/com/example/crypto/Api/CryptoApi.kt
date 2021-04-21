package com.example.crypto.Api


import retrofit2.Call
import retrofit2.http.GET

interface CryptoApi {
    @GET("v2/assets")
    fun getSummary(): Call<SummaryResponse>
}