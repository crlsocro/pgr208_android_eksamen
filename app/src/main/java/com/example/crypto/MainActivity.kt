package com.example.crypto

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Debug
import android.view.View
import androidx.appcompat.app.AppCompatActivity

//Screen 1
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        object : CountDownTimer(300000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                //Unødvendig method, men må vær her. Finn bedre måte
                print("Hello");
            }

            override fun onFinish() {
                nextScreen()
            }
        }.start()
    }

    fun nextScreen() {
        val intent = Intent(this, CryptoActivity::class.java).apply {

        }
        startActivity(intent)
    }

}
