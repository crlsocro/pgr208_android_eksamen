package com.example.crypto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.crypto.Adapter.CryptoListAdapter
import java.util.jar.Attributes

//Screen 4

class BuySellActivity : AppCompatActivity() {

    val symbol : String? = ""
    var priceUsd : String? = ""
    var name : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_sell)

        val i : String? = intent.extras?.getString(Name, "btc")
        val j : String? = getIntent().getExtras()?.getString(CryptoListAdapter, "btc")
        println(i)
    }


}