package com.example.crypto.database

import androidx.room.Entity
import androidx.room.PrimaryKey

    @Entity
    data class Transaction(
        @PrimaryKey(autoGenerate = true) val transactionID: Int,
        val currency: String?,
        val amount: Float?,
        val price: Float?,
        val transactionType: String?
    )
