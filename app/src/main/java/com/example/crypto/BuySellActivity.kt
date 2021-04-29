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

import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.charts.Cartesian
import java.util.ArrayList

//Screen 4


//TODO: Fetch graph to be correct data from the assets endpoints

class BuySellActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_sell)

       // setSupportActionBar(findViewById(R.id.toolbar))

        drawSinGraph();

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


        //Declaration for buttons on screen 4
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
    private fun drawSinGraph() {

        var series: ArrayList<DataEntry> = ArrayList()

        for ( angle in 0..360 ) {

            var radian = Math.toRadians( angle.toDouble())
            series.add( ValueDataEntry( /* x-axis */ angle , /* y-axis */ Math.sin(radian) ) )
        }

        // Step 2 assign series to AnyChart column (Data Structure of library)
        val cartesian: Cartesian = AnyChart.column()
        cartesian.column(series) // set your

        // Step 3 assign column to chartview
        val chartView = findViewById<AnyChartView>(R.id.chartView)
        chartView.setChart(cartesian)
        
    }
}