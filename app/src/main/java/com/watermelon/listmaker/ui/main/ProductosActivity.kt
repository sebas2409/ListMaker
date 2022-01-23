package com.watermelon.listmaker.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.watermelon.listmaker.MainActivity
import com.watermelon.listmaker.R
import com.watermelon.listmaker.Tareas
import com.watermelon.listmaker.databinding.ProductosActivityBinding
import com.watermelon.listmaker.ui.main.ui.main.ProductosFragment

class ProductosActivity : AppCompatActivity() {
    private lateinit var binding: ProductosActivityBinding
    lateinit var lista: Tareas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ProductosActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lista = intent.getParcelableExtra(MainActivity.LISTA_PRODUCTO_CLAVE)!!
        title = lista.nombre


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.productosContainer, ProductosFragment.newInstance())
                .commitNow()
        }
    }
}