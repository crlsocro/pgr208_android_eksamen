package com.example.crypto.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crypto.Repo.CryptoRepo
import com.example.crypto.Repo.CryptoStats
import com.example.crypto.database.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(context: Context) : ViewModel() {

    private var balanceDao : BalanceDAO = CryptoDatabase.get(context).getBDAO()
    private var liveBalance = MutableLiveData<List<Balance>>()
    val liveStats = MutableLiveData<List<CryptoStats>> (ArrayList<CryptoStats>())
    val isLoading = MutableLiveData<Boolean> (false)

    private val repo = CryptoRepo()

    fun getBalances() : MutableLiveData<List<Balance>> {

        viewModelScope.launch {
            var resultB = withContext(Dispatchers.IO){
                balanceDao.getAllBalances()
            }

            liveBalance.value = resultB // updating the value
        }

        return liveBalance
    }

    private var transactionDao : TransactionDAO = CryptoDatabase.get(context).getTDAO()
    private var liveTransaction = MutableLiveData<List<Transaction>>()

    fun getTransactions() : MutableLiveData<List<Transaction>> {

        viewModelScope.launch {
            var resultT = withContext(Dispatchers.IO){
                transactionDao.getAllTransactions()
            }

            liveTransaction.value = resultT // updating the value
        }

        return liveTransaction
    }

}