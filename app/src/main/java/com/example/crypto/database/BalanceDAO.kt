package com.example.crypto.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update

@Dao
interface BalanceDAO {
    @Insert
    fun addPurchase(balance: Balance)

    @Update
    fun delete(balance: Balance)



}