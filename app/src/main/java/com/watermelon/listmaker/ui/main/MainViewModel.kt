package com.watermelon.listmaker.ui.main

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.watermelon.listmaker.Tareas

class MainViewModel(private val sharedPreferences: SharedPreferences) : ViewModel() {


    lateinit var onListAdded: (()->Unit)

    val listas: MutableList<Tareas> by lazy {
        devolverListas()
    }

    private fun devolverListas():MutableList<Tareas>{
        val sharedPreferencesContents = sharedPreferences.all
        val tareas = ArrayList<Tareas>()

        for (tarea in sharedPreferencesContents){
            val itemHashSet = ArrayList(tarea.value as HashSet<String>)
            val lista = Tareas(tarea.key, itemHashSet)
            tareas.add(lista)
        }
        return tareas
    }

    fun saveList(lista : Tareas){
        sharedPreferences.edit().putStringSet(lista.nombre,lista.tareas.toHashSet()).apply()
        listas.add(lista)
        onListAdded.invoke()
    }


}