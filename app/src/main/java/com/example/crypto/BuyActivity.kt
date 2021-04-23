package com.example.crypto

import android.R
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso


//Screen 5

class BuyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.crypto.R.layout.activity_buy)

        var btn : Button = findViewById(com.example.crypto.R.id.buyButton)
        btn.isEnabled = false

        var usdEdit : EditText = findViewById<EditText>(com.example.crypto.R.id.editTextUSD)
        if (Integer.parseInt(usdEdit.text.toString()) > 5 || usdEdit.text.toString() == ""){
            btn.isEnabled = true
        }

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

//TODO Buttons are only enabled when the user has enough crypto to buy/sell