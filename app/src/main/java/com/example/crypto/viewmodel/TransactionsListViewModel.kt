package com.example.crypto.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crypto.database.CryptoDatabase
import com.example.crypto.database.Transaction
import com.example.crypto.database.TransactionDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TransactionsListViewModel : ViewModel() {

    private lateinit var transactionDAO : TransactionDAO

    private val _transactionsListLiveData: MutableLiveData<List<Transaction>> = MutableLiveData()
    val transactionsListLiveData: LiveData<List<Transaction>> = _transactionsListLiveData


    fun init(context: Context) {
        // Initialize the database
        transactionDAO = CryptoDatabase.get(context).getTDAO()
        // fetch the list of students available in database
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
            _transactionsListLiveData.postValue(transactionDAO.getAllTransactions())
            }
        }
    }
}