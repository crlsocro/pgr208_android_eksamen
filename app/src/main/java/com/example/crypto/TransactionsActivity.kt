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
}

