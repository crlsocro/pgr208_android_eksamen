package com.example.crypto

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

//Screen 2
class CryptoListActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crypto_list)

    }

    fun toPortfolio(){

    }

    fun toPortfolio(view: View) {
        val intent = Intent(this, PortfolioActivity::class.java).apply {

        }
        startActivity(intent)
    }

}