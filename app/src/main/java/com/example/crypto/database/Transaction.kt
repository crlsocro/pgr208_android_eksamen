package com.example.crypto.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transaction_table")
data class Transaction(
        @PrimaryKey(autoGenerate = true) val transactionID: Int,
        val currency: String?,
        val amount: Double,
        val price: Double,
        val transactionType: String?
)
