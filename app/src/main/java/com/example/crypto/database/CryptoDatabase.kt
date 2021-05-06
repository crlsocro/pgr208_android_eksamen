package com.example.crypto.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



@Database(entities = [Balance::class, Transaction::class], version = 3)
abstract class CryptoDatabase : RoomDatabase(){
    abstract fun getBDAO(): BalanceDAO
    abstract fun getTDAO(): TransactionDAO

    companion object {

       var DB_FILENAME  = "mycryptodb"

       @Volatile
       private var INSTANCE: CryptoDatabase? = null

       fun get(context: Context): CryptoDatabase {
           val tmp =
               INSTANCE
           if (tmp != null) {
               return tmp
           }
           synchronized(this) {
               val instance =
                   Room.databaseBuilder(context.applicationContext, CryptoDatabase::class.java, DB_FILENAME)
                   .fallbackToDestructiveMigration()
                   .build()

               INSTANCE = instance
               //TODO INSTANCE = it might not work. check the DataBase.kt in gitbuh if this does not work
               return instance.also { INSTANCE = it }
           }
       }
   }

}


