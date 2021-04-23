package com.example.crypto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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


    }

    fun toBuyActivity(view: View) {
        val intent = Intent(this,BuyActivity::class.java).apply {
        }
        startActivity(intent)
    }

    fun toSellActivity(view: View) {
        val intent = Intent(this,SellActivity::class.java).apply {

        }
        startActivity(intent)
    }
}