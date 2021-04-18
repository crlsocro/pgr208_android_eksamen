package com.example.crypto.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = [Balance::class, Transaction::class], version = 1)
abstract class Database : RoomDatabase(){
    abstract fun BalanceDAO(): BalanceDAO
    abstract fun TransactionDAO(): TransactionDAO

    /*companion object {
        private var db: DataBase? = null

        // Get the singleton instance of Database object.
        fun getDatabase(context: Context): DataBase {
            val newDb =
                    db ?: Room.databaseBuilder(context, DataBase::class.java, DATABASE_NAME).build()
            return newDb.also {
                db = it
            }
        }

    }*/
}


