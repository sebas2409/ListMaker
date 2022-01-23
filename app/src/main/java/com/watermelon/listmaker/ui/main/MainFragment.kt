package com.watermelon.listmaker.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.watermelon.listmaker.Tareas
import com.watermelon.listmaker.databinding.MainFragmentBinding

class MainFragment(val clickListener: MainFragmentListener) : Fragment(),ListasAdapter.SeleccionClickListener {
    interface MainFragmentListener{
        fun itemTapped(lista : Tareas)
    }

    private lateinit var binding: MainFragmentBinding
    private lateinit var viewModel : MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater,container,false)

        binding.rvNombreListas.layoutManager = LinearLayoutManager(requireContext())


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         viewModel = ViewModelProvider(requireActivity(),
             MainViewModelFactory(PreferenceManager.getDefaultSharedPreferences(requireActivity())))[MainViewModel::class.java]
        binding.rvNombreListas.adapter = ListasAdapter(viewModel.listas,this)
        viewModel.onListAdded = {ListasAdapter(viewModel.listas,this).actualizar()}

    }
    companion object {
        fun newInstance(clickListener: MainFragmentListener) = MainFragment(clickListener)
    }

    override fun itemSeleccionado(lista: Tareas) {

    }


}