package com.example.crypto.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crypto.database.Transaction
import com.example.crypto.databinding.ItemTransactionViewBinding
import com.squareup.picasso.Picasso

class TransactionsAdapter(val lambdaFunction: (Transaction) -> Unit) : RecyclerView.Adapter<TransactionsAdapter.ViewHolder>(){

    private val transactionsList = mutableListOf<Transaction>()

    class ViewHolder(val binding: ItemTransactionViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(transaction: Transaction) {
            //TODO add the images
            //TODO change xml to display these values
            binding.textViewTransactionIDT.text = transaction.transactionID.toString()
            binding.textViewCryptoNameT.text = transaction.currency
            binding.textViewAmountT.text = transaction.amount.toString()
            binding.textViewPriceT.text = transaction.price.toString()
            binding.textViewTransactionTypeT.text = transaction.transactionType
            Picasso.get().load("https://static.coincap.io/assets/icons/${transaction.currency!!.toLowerCase()}@2x.png").into(binding.imageViewIconT)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val holder = ViewHolder(ItemTransactionViewBinding.inflate(LayoutInflater.from(parent.context)))
        holder.itemView.setOnClickListener {
            lambdaFunction(transactionsList[holder.adapterPosition])
        }
        return holder
    }

    override fun getItemCount(): Int {
        return transactionsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(transactionsList[position])
    }

    fun setTransactionList(list: List<Transaction>) {
        transactionsList.clear()
        transactionsList.addAll(list)
        notifyDataSetChanged()
    }

}
