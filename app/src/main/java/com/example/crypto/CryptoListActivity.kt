package com.example.crypto

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crypto.Adapter.CryptoListAdapter
import com.example.crypto.Repo.CryptoStats
import com.example.crypto.databinding.ActivityCryptoListBinding
import com.example.crypto.viewmodel.LoadingViewModel

//Screen 2
class CryptoListActivity : AppCompatActivity(){

    private var listAdapter = CryptoListAdapter(ArrayList<CryptoStats>())
    private val viewModel = LoadingViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityCryptoListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = listAdapter

        viewModel.liveStats.observe(this, { newList->
            listAdapter.update(newList)
        })

        viewModel.isLoading.observe(this,){loading ->
            binding.progressBar.visibility = if(loading) View.VISIBLE else View.INVISIBLE
        }

    }

    override fun onResume() {
        super.onResume()
        viewModel.refresh()
    }

    fun toPortfolio(){

    }

    fun toPortfolio(view: View) {
        val intent = Intent(this, PortfolioActivity::class.java).apply {

        }
        startActivity(intent)
    }

}