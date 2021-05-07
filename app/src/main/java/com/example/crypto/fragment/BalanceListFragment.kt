package com.example.crypto.fragment

import com.example.crypto.R
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crypto.Adapter.PortfolioAdapter
import com.example.crypto.databinding.ActivityBalanceListFragmentBinding
import com.example.crypto.viewmodel.BalanceListViewModel

class BalanceListFragment : Fragment(R.layout.activity_balance_list_fragment) {

    companion object {
        fun newInstance() = BalanceListFragment()
    }

    private val adapter = PortfolioAdapter {}
    private lateinit var binding: ActivityBalanceListFragmentBinding
    private val viewModel: BalanceListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ActivityBalanceListFragmentBinding.bind(view)
        viewModel.init(requireContext())

        configureList()
        observe()
    }

    private fun observe() {
        viewModel.balanceListLiveData.observe(viewLifecycleOwner) {
            adapter.setBalanceList(it)
        }
    }

    private fun configureList() {
        binding.balanceList.layoutManager = LinearLayoutManager(requireContext())
        binding.balanceList.adapter = adapter
    }

}