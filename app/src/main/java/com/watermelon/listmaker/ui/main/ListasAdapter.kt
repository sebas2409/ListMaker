package com.watermelon.listmaker.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.watermelon.listmaker.Tareas
import com.watermelon.listmaker.databinding.ListasHolderBinding


class ListasAdapter(private val lista : MutableList<Tareas>, val clickListener: SeleccionClickListener) : RecyclerView.Adapter<ListasAdapter.ListasHolder>() {

interface SeleccionClickListener{
    fun itemSeleccionado(lista : Tareas)
}

    class ListasHolder(val binding: ListasHolderBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListasHolder {
        val binding = ListasHolderBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ListasHolder(binding)
    }

    override fun onBindViewHolder(holder: ListasHolder, position: Int) {
        holder.binding.itemNumber.text = (position + 1 ).toString()
        holder.binding.itemString.text = lista[position].nombre
        holder.itemView.setOnClickListener{
            clickListener.itemSeleccionado(lista[position])
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }
    fun actualizar(){
        notifyItemInserted(lista.size - 1)
    }

}
