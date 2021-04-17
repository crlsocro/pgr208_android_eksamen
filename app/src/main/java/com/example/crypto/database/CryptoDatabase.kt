package com.example.crypto.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 1, entities = [Transaction::class, Balance::class])
abstract class CryptoDatabase : RoomDatabase(){

    abstract fun balanceDAO(): BalanceDAO
    abstract fun transactionDAO(): TransactionDAO
}


