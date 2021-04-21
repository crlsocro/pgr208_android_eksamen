package com.example.crypto.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crypto.Repo.CryptoStats
import com.example.crypto.databinding.ItemCryptoViewBinding
import com.example.crypto.databinding.ItemTransactionViewBinding
import com.squareup.picasso.Picasso

class TransactionsAdapter() : RecyclerView.Adapter<CryptoListAdapter.CryptoViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionsAdapter.TransactionsViewHolder {
        val binding = ItemTransactionViewBinding.inflate(LayoutInflater.from(parent.context))
        return TransactionsAdapter.TransactionsViewHolder(binding)
    }

    class TransactionsViewHolder(private val binding: ItemTransactionViewBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(stats: CryptoStats) {
            Picasso.get().load("https://static.coincap.io/assets/icons/${stats.symbol?.toLowerCase()}@2x.png").into(binding.imageViewIconTransaction)
            binding.textViewCryptoName.text  = "${stats.name}"
            binding.textViewCryptoSymbol.text = "${stats.symbol}"
            binding.textViewCryptoPriceUsd.text  = "${stats.priceUsd}"
            binding.textViewPercent.text = "${stats.changePercent24Hr}%"

        }
    }
}