package com.example.crypto.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TransactionDAO {
    @Insert
    fun addTransaction(transaction: Transaction)

    @Update
    fun update(transaction: Transaction)

    @Delete
    fun delete(transaction: Transaction)

    //Read all transactions from database
    @Query("SELECT * FROM transaction_table")
    fun getAllTransactions(): List<Transaction>

    @Query("select * from transaction_table where transactionType = :transactionType")
    suspend fun getGiftTransaction(transactionType: String): Transaction



}