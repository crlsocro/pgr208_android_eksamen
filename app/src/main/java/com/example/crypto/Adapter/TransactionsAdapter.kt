package com.example.crypto.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crypto.BuySellActivity
import com.example.crypto.Repo.CryptoStats
import com.example.crypto.database.Balance
import com.example.crypto.databinding.ItemCryptoViewBinding
import com.example.crypto.databinding.ItemTransactionViewBinding
import com.squareup.picasso.Picasso

class TransactionsAdapter(val lambdaFunction: (Balance) -> Unit) : RecyclerView.Adapter<TransactionsAdapter.ViewHolder>(){

    private val balanceList = mutableListOf<Balance>()

    class ViewHolder(val binding: ItemTransactionViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(balance: Balance) {
            binding.textViewPrice.text = balance.balanceID.toString()
            binding.textViewCryptoNameTransaction.text = balance.currency
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val holder = ViewHolder(ItemTransactionViewBinding.inflate(LayoutInflater.from(parent.context)))
        holder.itemView.setOnClickListener {
            lambdaFunction(balanceList[holder.adapterPosition])
        }
        return holder
    }

    override fun getItemCount(): Int {
        return balanceList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(balanceList[position])
    }

    fun setBalanceList(list: List<Balance>) {
        balanceList.clear()
        balanceList.addAll(list)
        notifyDataSetChanged()
    }

}
