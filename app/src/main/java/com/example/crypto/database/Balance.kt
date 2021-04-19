package com.example.crypto.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "balance_table")
data class Balance(
        @PrimaryKey(autoGenerate = true) val balanceID: Int,
        val currency: String?,
        val amount: Double,
        val totalWorth: Double
)