package com.example.crypto.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crypto.databinding.ItemCryptoViewBinding
import com.example.crypto.models.CryptoStats

class CryptoListAdapter(private var list: List<CryptoStats>) : RecyclerView.Adapter<CryptoListAdapter.CryptoViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val binding =  ItemCryptoViewBinding.inflate(LayoutInflater.from(parent.context))
        return CryptoViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class CryptoViewHolder(private val binding: ItemCryptoViewBinding) : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(stats: CryptoStats) {
            binding.textViewCryptoCases.text  = stats.id
            binding.textViewCryptoCases.text  = stats.symbol
            binding.textViewCryptoCases.text  = "${stats.priceUsd}"

        }
    }

    fun update(newList: List<CryptoStats>){
        list = newList
        notifyDataSetChanged()
    }

}