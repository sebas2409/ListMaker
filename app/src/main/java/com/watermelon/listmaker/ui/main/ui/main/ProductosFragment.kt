package com.watermelon.listmaker.ui.main.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.watermelon.listmaker.databinding.ProductosFragmentBinding


class ProductosFragment : Fragment() {

    companion object {
        fun newInstance() = ProductosFragment()
    }

    private lateinit var viewModel: ProductosViewModel
    private lateinit var binding: ProductosFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProductosFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[ProductosViewModel::class.java]
    }

}