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
//TODO Buttons are only enabled when the user has enough crypto to buy/sell
//TODO: When entering in the USD column, for example 3000, it should convert to the BTC value automatically.

class BuyActivity : AppCompatActivity() {

    private lateinit var viewModelT: TransactionViewModel
    private lateinit var viewModelB: BalanceViewModel
    var symbol : String = ""
    var name : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.crypto.R.layout.activity_buy)
/*
        var btn : Button = findViewById(com.example.crypto.R.id.buyButton)
        btn.isEnabled = false

        var usdEdit : EditText = findViewById<EditText>(com.example.crypto.R.id.editTextUSD)
        if (Integer.parseInt(usdEdit.text.toString()) > 5 || usdEdit.text.toString() == ""){
            btn.isEnabled = true
        }
*/
        //TODO verify the input before submitting to database. i.e if(value != String)
        //TODO maybe clean up code by making a collectAllData function?
        //TODO the crypto amount should be textview, not editable by user
        //TODO the crypto amount should be calculated automatically
        //TODO crypto with long "symbol" gets wrapped, extend name and name2

        //FIXED: the user interface always says "BTC" under the USD, not the actual crypto
        //FIXED: the crypto image always shows bitcoin image, not the actual crypto image

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
                    //println(editTextUSDPrice.text.toString())
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

            if (viewModelB.theCoin.currency == symbol){
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




        //println(testB.amount)


/*
        viewModelB = BalanceViewModel(this)

        var testB = Balance(0, symbol, amount, priceUSD)
        viewModelB.addCryptoBalance(testB)

 */
    }

}

