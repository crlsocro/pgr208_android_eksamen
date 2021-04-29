package com.example.crypto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

//Screen 6

//TODO: When entering in the USD column, for example 3000, it should convert to the BTC value automatically.

class SellActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sell)

        var btn : Button = findViewById(R.id.sellButton)
        btn.isEnabled = false

        var intent = intent
        val symbol = intent.getStringExtra("symbol")
        val price = intent.getStringExtra("price")
        val name = intent.getStringExtra("name")
        val textViewSymbol = findViewById<TextView>(com.example.crypto.R.id.symbol)
        val textViewPrice = findViewById<TextView>(com.example.crypto.R.id.price)
        val textViewName = findViewById<TextView>(com.example.crypto.R.id.name)
        val imageView: ImageView = findViewById(com.example.crypto.R.id.imageIcon)
        textViewSymbol.text = symbol
        textViewPrice.text = price
        textViewName.text = name
        Picasso.get().load("https://static.coincap.io/assets/icons/${symbol?.toLowerCase()}@2x.png").into(imageView)
    }
}