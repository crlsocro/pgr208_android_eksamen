package com.example.crypto.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crypto.database.Balance
import com.example.crypto.databinding.ItemPortfolioViewBinding
import com.example.crypto.databinding.ItemTransactionViewBinding
import com.squareup.picasso.Picasso

class PortfolioAdapter (val lambdaFunction: (Balance) -> Unit) : RecyclerView.Adapter<PortfolioAdapter.ViewHolder>(){

    private val balanceList = mutableListOf<Balance>()

    class ViewHolder(val binding: ItemPortfolioViewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(balance: Balance){
            binding.textViewCryptoNameBalance.text = balance.balanceID.toString()
            binding.textViewCryptoSymbolBalance.text = balance.balanceID.toString()
            binding.textViewCryptoPriceUsdBalance.text = balance.balanceID.toString()
            Picasso.get().load("https://static.coincap.io/assets/icons/${balance.currency!!.toLowerCase()}@2x.png").into(binding.imageViewIconBalance)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortfolioAdapter.ViewHolder {
        val holder = PortfolioAdapter.ViewHolder(ItemPortfolioViewBinding.inflate(LayoutInflater.from(parent.context)))
        holder.itemView.setOnClickListener {
            lambdaFunction(balanceList[holder.adapterPosition])
        }
        return holder
    }

    override fun onBindViewHolder(holder: PortfolioAdapter.ViewHolder, position: Int) {
        holder.bind(balanceList[position])
    }

    override fun getItemCount(): Int {
        return balanceList.size
    }
    fun setBalanceList(list: List<Balance>) {
        balanceList.clear()
        balanceList.addAll(list)
        notifyDataSetChanged()
    }

}