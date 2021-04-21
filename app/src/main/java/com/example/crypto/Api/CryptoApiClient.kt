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
            .baseUrl("https://api.coincap.io/v2/")
            .build()

        cryptoApi = retrofit.create(CryptoApi::class.java)
    }
    fun getSummary(): List<CryptoStats> {

        var response = cryptoApi.getSummary().execute()

        try {
            if(response.isSuccessful) {
                response.body()?.CryptoN?.let { cryptoN ->
                    return cryptoN

                }
            }
        }
        catch (ex: Exception){
            ex.printStackTrace()
        }
        return ArrayList()

    }
}
/*
        package com.example.myapplication

class dummySource {
    fun getSummary(): List<CryptoStats>{
        var list = ArrayList<CryptoStats>()

        list.add(CryptoStats("Bitcoin",1, "BTC","Bitcoin", 6929.82))
        list.add(CryptoStats("ethereum",2, "ETH","Ethereum" ,404.97))


        return list
    }
}
 */