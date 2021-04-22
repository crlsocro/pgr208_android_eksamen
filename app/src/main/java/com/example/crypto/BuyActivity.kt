package com.example.crypto

import android.R
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


//Screen 5

class BuyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.crypto.R.layout.activity_buy)

        var btn : Button = findViewById(com.example.crypto.R.id.buyButton)
        btn.isEnabled = true

        var usdEdit : EditText = findViewById(com.example.crypto.R.id.editTextUSD) as EditText
        //if (usdEdit.getText().toInt() > 5)
    }

}

//TODO Buttons are only enabled when the user has enough crypto to buy/sell