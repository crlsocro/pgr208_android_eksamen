package com.example.crypto.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "balance_table")
data class Balance(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "balanceID")
        val balanceID: Int,
        @ColumnInfo(name = "currency")
        val currency: String?,
        @ColumnInfo(name = "amount")
        val amount: Double,
        @ColumnInfo(name = "price")
        val price: Double
)