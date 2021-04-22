package com.example.crypto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//Screen 4

class BuySellActivity : AppCompatActivity() {

    val symbol : String? = ""
    var priceUsd : String? = ""
    var name : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_sell)

        val i : String = intent.extras.toString()
        println(i)
    }


}