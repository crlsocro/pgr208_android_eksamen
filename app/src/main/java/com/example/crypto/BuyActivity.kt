package com.example.crypto

import android.R
import android.os.Bundle
import android.os.Debug
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.viewModelScope
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewModelScope
import com.example.crypto.database.Balance
import com.example.crypto.database.Transaction
import com.example.crypto.viewmodel.BalanceViewModel
import com.example.crypto.viewmodel.TransactionViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


//Screen 5

class BuyActivity : AppCompatActivity() {

    private lateinit var viewModelT: TransactionViewModel
    private lateinit var viewModelB: BalanceViewModel
    var symbol : String = ""
    var name : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.crypto.R.layout.activity_buy)

        var intent = intent
        symbol = intent.getStringExtra("symbol").toString()
        val price = intent.getStringExtra("price")
        name = intent.getStringExtra("name").toString()
        val textViewName2 = findViewById<TextView>(com.example.crypto.R.id.name2)
        val textViewSymbol = findViewById<TextView>(com.example.crypto.R.id.symbol)
        val textViewPrice = findViewById<TextView>(com.example.crypto.R.id.price)
        val textViewName = findViewById<TextView>(com.example.crypto.R.id.name)
        val textViewBTCPrice = findViewById<TextView>(com.example.crypto.R.id.editTextBTC)
        val editTextUSDPrice = findViewById<EditText>(com.example.crypto.R.id.editTextUSD)
        val imageView: ImageView = findViewById(com.example.crypto.R.id.imageIcon)
        textViewBTCPrice.text = symbol
        textViewName2.text = symbol
        textViewSymbol.text = symbol
        textViewPrice.text = price
        textViewName.text = name
        Picasso.get().load("https://static.coincap.io/assets/icons/${symbol.toLowerCase()}@2x.png").into(imageView)

        editTextUSDPrice.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (price != null) {
                    var commaless = price.replace(",", ".")
                    textViewBTCPrice.text = (editTextUSDPrice.text.toString().toDouble() / commaless.toDouble()).toString()
                }
            }

        })
    }

    fun sendPurchaseToDatabase(view: View) {
        val textViewUSDPrice = findViewById<EditText>(com.example.crypto.R.id.editTextUSD)
        val textViewBTCAmount = findViewById<TextView>(com.example.crypto.R.id.editTextBTC)
        //messy implementation
        val priceUSD : Double = textViewUSDPrice.text.toString().toDouble()
        var amount : Double = textViewBTCAmount.text.toString().toDouble()

        viewModelT = TransactionViewModel(this)
        viewModelB = BalanceViewModel(this)

        var testB = Balance(0, symbol, amount, priceUSD)


        try{
            viewModelB.getBalanceCoin(symbol)

            if (viewModelB.getCoin(symbol).currency == symbol){
                println("Hello coins")
                testB.amount += viewModelB.theCoin?.amount
            }else{
                println("OMG YOLO SWAG")
                println(testB.currency + " ")
                println(viewModelB.theCoin.currency + " ")
            }
            viewModelB.addCryptoBalance(testB)
        }catch( ex:Exception) {

        }


        var testT = Transaction(0, symbol, amount, priceUSD, "bought")
        viewModelT.addCryptoTransaction(testT)

    }

}

