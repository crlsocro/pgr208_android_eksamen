package com.example.crypto.Api

import android.os.Parcelable
import com.example.crypto.Repo.CryptoStats

import com.google.gson.annotations.SerializedName

data class HistoryResponse (
    @SerializedName("history")
    val id: List<CryptoStats>?
)
