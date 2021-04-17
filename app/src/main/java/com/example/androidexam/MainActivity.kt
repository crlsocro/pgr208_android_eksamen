package com.example.androidexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button =findViewById<Button>(R.id.buttonPoints)
        var button2 =findViewById<Button>(R.id.buttonCrypto)
        button.setOnClickListener {
                startActivity(intent)
            }
        button2.setOnClickListener {
            startActivity(intent)
        }
        }

}