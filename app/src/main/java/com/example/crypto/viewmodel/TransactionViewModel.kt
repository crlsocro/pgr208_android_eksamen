package com.example.crypto.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crypto.database.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TransactionViewModel(context: Context) : ViewModel() {

    private var transactionDAO : TransactionDAO = CryptoDatabase.get(context).getTDAO()

    //TODO change test to the name we use to insert or read from database
    //Change both instances of "test"
    //Bruk addCryptoTransaction for å legge til i databasen
    fun addCryptoTransaction (testT: Transaction){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                transactionDAO.addTransaction(testT)
            }
        }
    }

}