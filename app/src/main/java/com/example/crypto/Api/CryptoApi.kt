package com.example.crypto.Api

import retrofit2.Call
import retrofit2.http.GET

interface CryptoApi {
    @GET("assets")
    fun getSummary(): Call<SummaryResponse>
}