package com.example.crypto.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crypto.database.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BalanceListViewModel : ViewModel() {

    private lateinit var balanceDAO : BalanceDAO

    private val _balanceListLiveData: MutableLiveData<List<Balance>> = MutableLiveData()
    val balanceListLiveData: LiveData<List<Balance>> = _balanceListLiveData


    fun init(context: Context) {
        balanceDAO = CryptoDatabase.get(context).getBDAO()
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                _balanceListLiveData.postValue(balanceDAO.getAllBalances())
            }
        }
    }
}