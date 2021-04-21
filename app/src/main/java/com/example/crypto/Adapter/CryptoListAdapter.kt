package com.example.crypto.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crypto.Repo.CryptoStats
import com.example.crypto.databinding.ItemCryptoViewBinding
import com.squareup.picasso.Picasso


class CryptoListAdapter(private var list: List<CryptoStats>) : RecyclerView.Adapter<CryptoListAdapter.CryptoViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val binding = ItemCryptoViewBinding.inflate(LayoutInflater.from(parent.context))
        return CryptoViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class CryptoViewHolder(private val binding: ItemCryptoViewBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(stats: CryptoStats) {
            Picasso.get().load("https://static.coincap.io/assets/icons/${stats.symbol?.toLowerCase()}@2x.png").into(binding.imageViewIcon)
            binding.textViewCryptoName.text  = "${stats.name}"
            binding.textViewCryptoSymbol.text = "${stats.symbol}"
            binding.textViewCryptoPriceUsd.text  = "${stats.priceUsd}"
            binding.textViewPercent.text = "${stats.changePercent24Hr}%"

        }
    }

    fun update(newList: List<CryptoStats>){
        list = newList
        notifyDataSetChanged()
    }

}