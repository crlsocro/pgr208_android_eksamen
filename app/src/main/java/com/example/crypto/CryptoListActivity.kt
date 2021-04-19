package com.example.crypto

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crypto.adapters.CryptoListAdapter
import com.example.crypto.database.datasources.dummySource
import com.example.crypto.databinding.ActivityCryptoListBinding
import com.example.crypto.databinding.ActivityMainBinding
import com.example.crypto.models.CryptoStats

//Screen 2
class CryptoListActivity : AppCompatActivity(){

    private var listAdapter = CryptoListAdapter(ArrayList<CryptoStats>())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding  = ActivityCryptoListBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_crypto_list)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = listAdapter

        listAdapter.update(dummySource().getSummary())

    }

    fun toPortfolio(){

    }

    fun toPortfolio(view: View) {
        val intent = Intent(this, PortfolioActivity::class.java).apply {

        }
        startActivity(intent)
    }

}