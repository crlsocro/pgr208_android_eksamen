package com.example.crypto.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.crypto.R
import com.example.crypto.databinding.TransactionFragmentBinding
import com.example.crypto.viewmodel.TransactionViewModel

class TransactionFragment : Fragment(R.layout.transaction_fragment) {

    //STEAL THIS FOR BALANCE
    private var transactionID: Long? = null

    private lateinit var binding: TransactionFragmentBinding
    private val viewModel: TransactionViewModel by viewModels()

    companion object {
        fun newInstance(transactionID: Long? = null) = TransactionFragment().apply {
            if (transactionID != null) {
                arguments = Bundle().apply {
                    putLong("transactionID", transactionID)
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*
        // Init
        binding = TransactionFragmentBinding.bind(view)
        transactionID = arguments?.getLong("transactionID")
        // Init view model
        viewModel.init(requireContext(), transactionID)
        // View listeners
        initViewListeners()

        viewModel.transactionLiveData.observe(viewLifecycleOwner) {
            with(binding) {
                name.setText(it.currency)
                course.setText(it.transactionType)
                //saveButton.setText(R.string.update)
            }
        }*/
    }

    private fun initViewListeners() {
        with(binding) {
            saveButton.setOnClickListener {
                if (transactionID == null) {
                    viewModel.saveData(
                            name.text.toString(),
                            course.text.toString(),
                            50.0,
                            100.0,
                            999)
                } else {
                    //TODO fix the ugly af course.text
                    viewModel.updateData(
                            transactionID.toString(),
                            name.text.toString(),
                            Integer.parseInt(course.text.toString()).toDouble(),
                            50.0,
                            999)
                }
            }
        }
    }
}