package com.example.crypto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

//Screen 6

class SellActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sell)

        var btn : Button = findViewById(com.example.crypto.R.id.sellButton)
        btn.isEnabled = false
    }
}