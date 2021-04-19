package com.example.crypto.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crypto.Repo.CryptoRepo
import com.example.crypto.Repo.CryptoStats
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoadingViewModel : ViewModel() {
    private val repo = CryptoRepo()
    val liveStats = MutableLiveData<List<CryptoStats>> (ArrayList<CryptoStats>())
    val isLoading = MutableLiveData<Boolean> (false)

    fun refresh() {
        isLoading.value = true
        viewModelScope.launch {
            var result = withContext(Dispatchers.IO) {
                repo.getCryptoSummary()
            }
            isLoading.value = false
            liveStats.value = result
        }
    }
}