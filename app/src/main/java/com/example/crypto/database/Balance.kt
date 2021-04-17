package com.example.crypto.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Balance(
    @PrimaryKey(autoGenerate = true) val balanceID: Int,
    val currency: String?,
    val amount: Float?,
    val totalWorth: Float?,
)