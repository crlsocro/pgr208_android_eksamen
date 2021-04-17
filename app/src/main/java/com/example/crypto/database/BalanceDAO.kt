package com.example.crypto.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BalanceDAO {
    @Insert
    fun addBalance(balance: Balance)

    @Update
    fun update(balance: Balance)

    @Delete
    fun delete(balance: Balance)

    @Query("SELECT * FROM Balance")
    fun getAllBalances(): LiveData<List<Balance>>



}