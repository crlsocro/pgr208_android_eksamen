package com.example.crypto.Api


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoApi {
    @GET("/v2/assets")
    fun getSummary(): Call<SummaryResponse>

    @GET("/v2/assets/history?interval=d1")
    fun getHistory(@Query("id") id: String): Call<HistoryResponse>

}