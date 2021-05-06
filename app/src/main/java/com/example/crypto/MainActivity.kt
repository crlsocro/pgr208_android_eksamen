package com.example.crypto

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.crypto.database.Balance
import com.example.crypto.database.Transaction
import com.example.crypto.viewmodel.BalanceViewModel
import com.example.crypto.viewmodel.MainViewModel
import com.example.crypto.viewmodel.TransactionViewModel

//Screen 1
class MainActivity : AppCompatActivity() {

    //TODO check if you have been given the gift already

    private lateinit var viewModelT: TransactionViewModel
    private lateinit var viewModelB: BalanceViewModel
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModelT = TransactionViewModel(this)
        viewModelB = BalanceViewModel(this)

        var firstDepositT = Transaction(0, "USD", 10000.0, 1.0, "gift")
        viewModelT.addCryptoTransaction(firstDepositT)

        var firstDepositB = Balance(0, "USD", 10000.0, 1.0)
        viewModelB.addCryptoBalance(firstDepositB)

        object : CountDownTimer(3000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                //TODO Unødvendig method, men må vær her. FJERN? or EPIC???
                print("Hello");
            }

            override fun onFinish() {
                nextScreen()
                finish()
            }
        }.start()
    }

    fun nextScreen() {
        val intent = Intent(this, CryptoListActivity::class.java).apply {

        }
        startActivity(intent)
    }

}
