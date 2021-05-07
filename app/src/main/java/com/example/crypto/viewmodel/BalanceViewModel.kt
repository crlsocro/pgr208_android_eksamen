package com.example.crypto.viewmodel

import android.content.Context
import android.content.Entity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crypto.database.Balance
import com.example.crypto.database.BalanceDAO
import com.example.crypto.database.CryptoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class BalanceViewModel(context: Context) : ViewModel() {

    private var balanceDAO : BalanceDAO = CryptoDatabase.get(context).getBDAO()

    //TODO change test to the name we use to insert or read from database. also in buyactivity + sellactivity
    //Change both instances of "test"
    //Bruk addCryptoBalance for å legge til i databasen
    fun addCryptoBalance (testB: Balance){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                balanceDAO.addBalance(testB)
            }
        }
    }

    var theCoin : Balance = Balance(0, "", 0.0, 0.0)

    fun getCoin (currency: String): Balance {
        theCoin = balanceDAO.getBalancewithSymbol(currency)
        return theCoin
    }

    fun getBalanceCoin (currency:String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                try {
                    getCoin(currency)
                }catch (e: Exception){

                }

            }
        }
    }

}