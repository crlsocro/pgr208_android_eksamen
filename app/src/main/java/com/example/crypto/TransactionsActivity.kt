package com.example.crypto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crypto.databinding.ActivityCryptoListBinding
import com.example.crypto.databinding.ActivityTransactionsBinding
import com.example.crypto.viewmodel.MainViewModel
import com.example.crypto.viewmodel.TransactionViewModel

//Screen 7



class TransactionsActivity : AppCompatActivity() {

    private lateinit var viewModelT: TransactionViewModel
    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding2  = ActivityTransactionsBinding.inflate(layoutInflater)
        setContentView(binding2.root)

        binding2.recyclerView.layoutManager = LinearLayoutManager(this)
        binding2.recyclerView.adapter = listAdapter
    }
}