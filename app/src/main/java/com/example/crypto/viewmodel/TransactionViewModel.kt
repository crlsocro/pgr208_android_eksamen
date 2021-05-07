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

    fun init(context: Context, transactionType: String?) {
        // Initialize database
        transactionDAO = CryptoDatabase.get(context).getTDAO()
        if (transactionType != null) {
            getTransaction(transactionType)
        }
    }

    private fun getTransaction(transactionType: String?) {
        viewModelScope.launch {
            _transactionLiveData.value = transactionDAO.getGiftTransaction(transactionType!!)
        }
    }

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

    fun addCryptoTransaction (testT: Transaction){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                transactionDAO.addTransaction(testT)
            }
        }
    }

    fun updateData(currency: String?, transactionType: String?, amount: Double, price: Double, transactionID: Int) {
        viewModelScope.launch {
            if (!currency.isNullOrEmpty() && !transactionType.isNullOrEmpty()) {
                transactionDAO.update(Transaction(Integer.parseInt(currency), transactionType, amount, price, transactionID.toString()))
                Log.d("", "Updated")
            }
        }

    }

}