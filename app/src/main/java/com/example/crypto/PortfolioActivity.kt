package com.example.crypto

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.map
import androidx.lifecycle.observe
import com.example.crypto.database.Balance
import com.example.crypto.database.CryptoDatabase
import com.example.crypto.database.Transaction
import com.example.crypto.databinding.ActivityPortfolioBinding
import com.example.crypto.databinding.ActivityTransactionsBinding
import com.example.crypto.databinding.ItemPortfolioViewBinding
import com.example.crypto.databinding.ItemTransactionViewBinding
import com.example.crypto.fragment.BalanceListFragment
import com.example.crypto.fragment.TransactionsListFragment
import com.example.crypto.viewmodel.BalanceViewModel
import com.example.crypto.viewmodel.MainViewModel
import com.example.crypto.viewmodel.TransactionViewModel

//Screen 3
class PortfolioActivity : AppCompatActivity() {

    //TODO: Hente korrekt data når man har kjøpt forksjellige krypto
    //TODO: Fix design
    //TODO: Make a button work to go to Transactions

    private lateinit var binding: ActivityPortfolioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPortfolioBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, BalanceListFragment.newInstance(), "BalanceFragment")
                .commit()

    }

    fun toTransactions(view: View) {
        val intent = Intent(this, TransactionsActivity::class.java).apply {

        }
        startActivity(intent)
    }
}