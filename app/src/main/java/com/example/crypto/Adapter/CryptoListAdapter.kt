package com.example.crypto.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.crypto.BuySellActivity
import com.example.crypto.PortfolioActivity
import com.example.crypto.R
import com.example.crypto.Repo.CryptoStats
import com.example.crypto.databinding.ItemCryptoViewBinding
import com.squareup.picasso.Picasso
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
        init {

        }
        fun bind(stats: CryptoStats) {
            Picasso.get().load("https://static.coincap.io/assets/icons/${stats.symbol?.toLowerCase()}@2x.png").into(binding.imageViewIcon)
            binding.textViewCryptoName.text  = "${stats.name}"
            binding.textViewCryptoSymbol.text = "${stats.symbol}"
            binding.textViewCryptoPriceUsd.text  ="$" + "%.3f".format(stats.priceUsd?.toDouble())
            binding.textViewPercent.text = "%.3f".format(stats.changePercent24Hr?.toDouble()) + "%"
            binding.root.setOnClickListener{
                println("test")
                val intent = Intent(binding.root.context, BuySellActivity::class.java).apply {}
                intent.putExtra(Intent.EXTRA_TEXT, "${stats.symbol}")
                intent.putExtra(Intent.EXTRA_TEXT, "${stats.priceUsd}.toDouble()")
                intent.putExtra(Intent.EXTRA_TEXT, "${stats.name}")
                binding.root.context.startActivity(intent)
            }
        }
    }

    fun update(newList: List<CryptoStats>){
        list = newList
        notifyDataSetChanged()
    }

}