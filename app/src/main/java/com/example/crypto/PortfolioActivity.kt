package com.example.crypto

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.map
import com.example.crypto.database.Balance
import com.example.crypto.database.CryptoDatabase
import com.example.crypto.database.Transaction
import com.example.crypto.viewmodel.BalanceViewModel
import com.example.crypto.viewmodel.TransactionViewModel

//Screen 3
class PortfolioActivity : AppCompatActivity() {

    private lateinit var viewModelB: BalanceViewModel
    private lateinit var viewModelT: TransactionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portfolio)

        viewModelB = BalanceViewModel(this)
        viewModelT = TransactionViewModel(this)

    }

    fun testDatabase(view: View){
        var testB = Balance(0, "btc", 01.000, 50000.000)
        viewModelB.addCryptoBalance(testB)

        //Display the database (test)
        CryptoDatabase.get(this).getBDAO().getAllBalances().map { testB ->
            Log.d(this.javaClass.simpleName, testB.toString())
        }

        var testT = Transaction(0, "btc", 01.000, 50000.000, "bought")
        viewModelT.addCryptoTransaction(testT)

        //Display the database (test)
        CryptoDatabase.get(this).getTDAO().getAllTransactions().map { testT ->
            Log.d(this.javaClass.simpleName, testT.toString())
        }

    }

}