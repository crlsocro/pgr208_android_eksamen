package com.example.crypto

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.crypto.database.Balance
import com.example.crypto.database.BalanceDAO
import com.example.crypto.database.CryptoDatabase
import com.example.crypto.viewmodel.BalanceViewModel

//Screen 3
class PortfolioActivity : AppCompatActivity() {

    private lateinit var viewModel: BalanceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portfolio)

        viewModel = BalanceViewModel(this)

    }

    fun testDatabase(view: View){
        var test = Balance(0, "btc", 01.000, 50000.000)
        viewModel.addCryptoBalance(test)

        //Display the database (test)
        CryptoDatabase.get(this).getBDAO().getAllBalances().map { test ->
            Log.d(this.javaClass.simpleName, test.toString())
        }

    }

}