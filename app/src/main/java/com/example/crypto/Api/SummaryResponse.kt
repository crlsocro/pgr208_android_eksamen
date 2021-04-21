package com.example.crypto.Api

import com.example.crypto.Repo.CryptoStats

data class SummaryResponse(
    var data: List<CryptoStats>?,
    var timestamp: Long?)