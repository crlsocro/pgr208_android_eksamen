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

    @Query("SELECT * FROM Transaction")
    fun getAllTransactions(): LiveData<List<Transaction>>



}