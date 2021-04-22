package com.example.crypto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.crypto.Adapter.CryptoListAdapter
import com.squareup.picasso.Picasso
import java.lang.reflect.Array.getInt
import java.util.jar.Attributes

//Screen 4

class BuySellActivity : AppCompatActivity() {

    val symbol : String? = ""
    var priceUsd : String? = ""
    var name : String? = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_sell)

      //  val i : String? = intent.extras?.getString(Name, "btc")
     //   val j : String? = getIntent().getExtras()?.getString(CryptoListAdapter, "btc")
      //  println(i)

        val bundle = intent.extras

        var intent = intent
        val symbol = intent.getStringExtra("symbol")
        val price = intent.getStringExtra("price")
        val name = intent.getStringExtra("name")
        //val icon: Int? = bundle?.getInt("icon")

        val textViewSymbol = findViewById<TextView>(R.id.symbol)
        val textViewPrice = findViewById<TextView>(R.id.price)
        val textViewName = findViewById<TextView>(R.id.name)
        val imageView: ImageView = findViewById(R.id.imageIcon)
        textViewSymbol.text = symbol
        textViewPrice.text = price
        textViewName.text = name

        Picasso.get().load("https://static.coincap.io/assets/icons/${symbol?.toLowerCase()}@2x.png").into(imageView)


    }
}