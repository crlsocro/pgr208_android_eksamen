package com.example.crypto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.crypto.Adapter.CryptoListAdapter
import com.squareup.picasso.Picasso
import java.lang.reflect.Array.getInt
import java.util.jar.Attributes

//Screen 4

class BuySellActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_sell)

            var intent = intent
            val symbol = intent.getStringExtra("symbol")
            val price = intent.getStringExtra("price")
            val name = intent.getStringExtra("name")
            val textViewSymbol = findViewById<TextView>(R.id.symbol)
            val textViewPrice = findViewById<TextView>(R.id.price)
            val textViewName = findViewById<TextView>(R.id.name)
            val imageView: ImageView = findViewById(R.id.imageIcon)
            textViewSymbol.text = symbol
            textViewPrice.text = price
            textViewName.text = name
            Picasso.get().load("https://static.coincap.io/assets/icons/${symbol?.toLowerCase()}@2x.png").into(imageView)

        var btnBuy = findViewById<Button>(R.id.btnBuy)
        var btnSell = findViewById<Button>(R.id.btnSell)

        btnBuy.setOnClickListener {
            val i = Intent(this, BuyActivity::class.java)
            i.putExtra("symbol", intent.getStringExtra("symbol"))
            i.putExtra("price", intent.getStringExtra("price"))
            i.putExtra("name", intent.getStringExtra("name"))
            startActivity(i)
        }

        btnSell.setOnClickListener {
            val i = Intent(this, SellActivity::class.java)
            i.putExtra("symbol", intent.getStringExtra("symbol"))
            i.putExtra("price", intent.getStringExtra("price"))
            i.putExtra("name", intent.getStringExtra("name"))
            startActivity(i)
        }
    }
}