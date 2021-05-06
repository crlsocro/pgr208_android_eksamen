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

    @Query("SELECT * FROM balance_table")
    fun getAllBalances(): List<Balance>

    @Query("select * from balance_table where balanceID = :balanceID")
    suspend fun getBalancewithSymbol(balanceID: Long): Balance


}