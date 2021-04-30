package com.example.crypto

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity

//Screen 1
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        object : CountDownTimer(3000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                //: Unødvendig method, men må vær her.
                print("Hello");
            }

            override fun onFinish() {
                nextScreen()
                finish()
            }
        }.start()
    }

    fun nextScreen() {
        val intent = Intent(this, CryptoListActivity::class.java).apply {

        }
        startActivity(intent)
    }

}
