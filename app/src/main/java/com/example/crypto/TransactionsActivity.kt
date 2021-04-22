package com.example.crypto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crypto.database.Balance
import com.example.crypto.database.Transaction
import com.example.crypto.databinding.ActivityCryptoListBinding
import com.example.crypto.databinding.ActivityTransactionsBinding
import com.example.crypto.viewmodel.MainViewModel
import com.example.crypto.viewmodel.TransactionViewModel

//Screen 7



class TransactionsActivity : AppCompatActivity() {



    private lateinit var viewModelT: TransactionViewModel
    private lateinit var viewModel : MainViewModel
    val price : TextView = findViewById(R.id.textViewPrice)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transactions)



    }

    fun testDatabase(view: View){


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
                price.text = "${entity}"
            }
        })

    }
}

