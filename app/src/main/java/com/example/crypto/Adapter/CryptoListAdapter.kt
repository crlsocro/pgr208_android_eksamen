package com.example.crypto.Adapter

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.crypto.BuySellActivity
import com.example.crypto.PortfolioActivity
import com.example.crypto.R
import com.example.crypto.Repo.CryptoStats
import com.example.crypto.databinding.ItemCryptoViewBinding
import com.squareup.picasso.Picasso
import java.net.URI
import java.net.URL
import kotlin.math.roundToInt
import kotlin.math.roundToLong


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
            binding.textViewCryptoPriceUsd.text  ="$" + "%.3f".format(stats.priceUsd?.toDouble())
            binding.textViewCryptoName.text  = "${stats.name}"
            binding.textViewCryptoSymbol.text = "${stats.symbol}"
            binding.textViewPercent.text = "%.3f".format(stats.changePercent24Hr?.toDouble()) + "%"
            binding.root.setOnClickListener{
                println("test")
                val intent = Intent(binding.root.context, BuySellActivity::class.java)
                intent.putExtra("symbol", "${stats.symbol}")
                intent.putExtra("price", "%.3f".format(stats.priceUsd?.toDouble()))
                intent.putExtra("name", "${stats.name}")
                binding.root.context.startActivity(intent)
            }
            if(binding.textViewPercent.text.startsWith("-")) {
                binding.textViewPercent.setTextColor(Color.parseColor("#ed343d"))
            } else {
                binding.textViewPercent.setTextColor(Color.parseColor("#42f560"))
            }
        }
    }

    fun update(newList: List<CryptoStats>){
        list = newList
        notifyDataSetChanged()
    }

}