package com.example.crypto.Repo

import com.example.crypto.Api.CryptoApiClient
import com.example.crypto.DataSource.LiveSource

class CryptoRepo {

    private val liveSource  = LiveSource()
    private val cryptoApiClient = CryptoApiClient()

    suspend fun getCryptoSummary() : List<CryptoStats>  {
        var list  = cryptoApiClient.getSummary()
        return list.sortedByDescending { it.priceUsd }
    }

}