package com.example.crypto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.crypto.databinding.ActivityTransactionsBinding
import com.example.crypto.fragment.TransactionsListFragment

//Screen 7

//TODO white stripe in the UI
//TODO delete the data in the database before vi levera

class TransactionsActivity : AppCompatActivity() {


    /*
    private lateinit var viewModelT: TransactionViewModel
    private lateinit var viewModel : MainViewModel
    val price : TextView = findViewById(R.id.textViewPrice)*/
    private lateinit var binding: ActivityTransactionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionsBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, TransactionsListFragment.newInstance(), "TransactionFragment")
            .commit()

    }

    /*
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

    }*/
}

