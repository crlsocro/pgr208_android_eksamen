package com.example.crypto.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transaction_table")
data class Transaction(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "transactionID")
        val transactionID: Int,
        @ColumnInfo(name = "currency")
        val currency: String?,
        @ColumnInfo(name = "amount")
        val amount: Double,
        @ColumnInfo(name = "price")
        val price: Double,
        @ColumnInfo(name = "transactionType")
        val transactionType: String?
)
