package com.example.crypto

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.map
import com.example.crypto.database.Balance
import com.example.crypto.database.CryptoDatabase
import com.example.crypto.database.Transaction
import com.example.crypto.viewmodel.BalanceViewModel
import com.example.crypto.viewmodel.MainViewModel
import com.example.crypto.viewmodel.TransactionViewModel

//Screen 3
class PortfolioActivity : AppCompatActivity() {

    private lateinit var viewModelB: BalanceViewModel
    private lateinit var viewModelT: TransactionViewModel
    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portfolio)

        viewModelB = BalanceViewModel(this)
        viewModelT = TransactionViewModel(this)
        viewModel = MainViewModel(this)

    }

    override fun onResume() {
        super.onResume()

        viewModel.getBalances().observe(this, { list->
            list.map {entity->
                Log.d(this.javaClass.simpleName, entity.toString())
            }
        })

        viewModel.getTransactions().observe(this, { list->
            list.map {entity->
                Log.d(this.javaClass.simpleName, entity.toString())
            }
        })

    }



    fun testDatabase(view: View){
        var testB = Balance(0, "btc", 01.000, 50000.000)
        viewModelB.addCryptoBalance(testB)

        //Display the database (test)
        /*CryptoDatabase.get(this).getBDAO().getAllBalances().map { testB ->
            Log.d(this.javaClass.simpleName, testB.toString())
        }*/

        var testT = Transaction(0, "btc", 01.000, 50000.000, "bought")
        viewModelT.addCryptoTransaction(testT)

        //Display the database (test)
        /*CryptoDatabase.get(this).getTDAO().getAllTransactions().map { testT ->
            Log.d(this.javaClass.simpleName, testT.toString())
        }*/

        viewModel.getTransactions().observe(this, { list->
            list.map {entity->
                Log.d(this.javaClass.simpleName, entity.toString())
            }
        })

    }


    fun toTransactions(view: View) {
        val intent = Intent(this, TransactionsActivity::class.java).apply {

        }
        startActivity(intent)
    }

}