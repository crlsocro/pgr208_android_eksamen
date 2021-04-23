package com.example.crypto.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crypto.database.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TransactionViewModel(context: Context) : ViewModel() {

    private var transactionDAO : TransactionDAO = CryptoDatabase.get(context).getTDAO()

    private val _transactionLiveData: MutableLiveData<Transaction> = MutableLiveData()
    val transactionLiveData: LiveData<Transaction> = _transactionLiveData

    fun init(context: Context, transactionID: Long?) {
        // Initialize database
        transactionDAO = CryptoDatabase.get(context).getTDAO()
        if (transactionID != null) {
            getTransaction(transactionID)
        }
    }

    private fun getTransaction(transactionID: Long) {
        viewModelScope.launch {
            _transactionLiveData.value = transactionDAO.getBalancewithSymbol(transactionID)
        }
    }

    //TODO this function operates the same as addCryptoTransaction. find out which is the best
    //TODO add all variables we need to display a transaction
    //Last three parameters does not have a "?", idk got error
    fun saveData(currency: String?, transactionType: String?, amount: Double, price: Double, transactionID: Int) {
        viewModelScope.launch {
            if (!currency.isNullOrEmpty() && !transactionType.isNullOrEmpty()) {
                try {
                    transactionDAO.addTransaction(Transaction(currency = currency, transactionType = transactionType, amount = amount, price = price, transactionID = transactionID))
                } catch (e: Exception) {
                    e.fillInStackTrace()
                }
            }
        }

    }

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

    //TODO add this function when copying this to balance

    fun updateData(currency: String?, transactionType: String?, amount: Double, price: Double, transactionID: Int) {
        viewModelScope.launch {
            if (!currency.isNullOrEmpty() && !transactionType.isNullOrEmpty()) {
                transactionDAO.update(Transaction(Integer.parseInt(currency), transactionType, amount, price, transactionID.toString()))
                Log.d("", "Updated")
            }
        }

    }

}