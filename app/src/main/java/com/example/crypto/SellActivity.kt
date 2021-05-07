package com.example.crypto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

//Screen 6

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
        val textViewName2 = findViewById<TextView>(com.example.crypto.R.id.name2)
        val textViewSymbol = findViewById<TextView>(com.example.crypto.R.id.symbol)
        val textViewPrice = findViewById<TextView>(com.example.crypto.R.id.price)
        val textViewName = findViewById<TextView>(com.example.crypto.R.id.name)
        val imageView: ImageView = findViewById(com.example.crypto.R.id.imageIcon)
        val BTCeditText = findViewById<EditText>(com.example.crypto.R.id.BTCeditText)
        val USDtextView = findViewById<TextView>(com.example.crypto.R.id.USDtextView)
        textViewName2.text = symbol
        textViewSymbol.text = symbol
        textViewPrice.text = price
        textViewName.text = name
        Picasso.get().load("https://static.coincap.io/assets/icons/${symbol?.toLowerCase()}@2x.png").into(imageView)

        BTCeditText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (price != null) {
                    //println(editTextUSDPrice.text.toString())
                    var commaless = price.replace(",", ".")
                    USDtextView.text = (BTCeditText.text.toString().toDouble() * commaless.toDouble()).toString()
                }
            }

        })
    }
}