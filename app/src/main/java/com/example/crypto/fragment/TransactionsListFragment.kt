package com.example.crypto.fragment

import com.example.crypto.Adapter.TransactionsAdapter
import com.example.crypto.R
import com.example.crypto.databinding.TransactionsListFragmentBinding
import com.example.crypto.viewmodel.TransactionsListViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager

class TransactionsListFragment : Fragment(R.layout.transactions_list_fragment) {

    companion object {
        fun newInstance() = TransactionsListFragment()
    }

    private val adapter = TransactionsAdapter {}
    private lateinit var binding: TransactionsListFragmentBinding
    private val viewModel: TransactionsListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Init
        binding = TransactionsListFragmentBinding.bind(view)
        // Init view model
        viewModel.init(requireContext())

        configureList()
        observe()
        // Listeners for view events
    }

    private fun observe() {
        viewModel.transactionsListLiveData.observe(viewLifecycleOwner) {
            adapter.setTransactionList(it)
        }
    }

    private fun configureList() {
        binding.transactionsList.layoutManager = LinearLayoutManager(requireContext())
        binding.transactionsList.adapter = adapter
    }

}