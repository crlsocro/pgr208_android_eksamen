package com.example.crypto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

//Screen 5

class BuyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy)
    }
}

//TODO Buttons are only enabled when the user has enough crypto to buy/sell