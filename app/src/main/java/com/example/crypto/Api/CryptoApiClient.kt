package com.example.crypto.Api


import com.example.crypto.Repo.CryptoStats

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CryptoApiClient {

    private var cryptoApi: CryptoApi

    init {
        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://api.coincap.io/")
            .build()

        cryptoApi = retrofit.create(CryptoApi::class.java)
    }
    fun getSummary(): List<CryptoStats> {

        var response = cryptoApi.getSummary().execute()

        try {
            if(response.isSuccessful) {
                response.body()?.data?.let { data ->
                    return data
                }
            }
        }
        catch (ex: Exception){
            ex.printStackTrace()
        }
        return ArrayList()

    }
    fun getHistory(): List<CryptoStats>{
        var responser = cryptoApi.getHistory(toString()).execute()

        try {
            if(responser.isSuccessful) {
                responser.body()?.id?.let { data ->
                    return data
                }
            }
        }
        catch (ex: Exception){
            ex.printStackTrace()
        }
        return ArrayList()
    }
}
