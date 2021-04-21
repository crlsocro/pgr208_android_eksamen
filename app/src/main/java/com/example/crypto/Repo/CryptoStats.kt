package com.example.crypto.Repo

data class CryptoStats(
    var id: String,
    var rank: Int,
    var name: String,
    var symbol: String,
    var priceUsd: Double
)