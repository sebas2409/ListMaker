package com.watermelon.listmaker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import com.watermelon.listmaker.databinding.MainActivityBinding
import com.watermelon.listmaker.ui.main.MainFragment
import com.watermelon.listmaker.ui.main.MainViewModel
import com.watermelon.listmaker.ui.main.MainViewModelFactory
import com.watermelon.listmaker.ui.main.ProductosActivity


class MainActivity : AppCompatActivity(),MainFragment.MainFragmentListener {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         viewModel = ViewModelProvider(this,
            MainViewModelFactory(PreferenceManager.getDefaultSharedPreferences(this))
        )[MainViewModel::class.java]

        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.productosContainer, MainFragment.newInstance(this))
                .commitNow()
        }

        binding.btnAlertDialog.setOnClickListener{
            mostrarDialog()
        }

    }
    private fun mostrarDialog(){
        val builder = AlertDialog.Builder(this)
        val view = EditText(this)
        view.inputType = InputType.TYPE_CLASS_TEXT

        builder
            .setTitle("Cual es el nombre de tu lista?")
            .setView(view)
            .setPositiveButton("Añadir"){dialog,_ ->
                viewModel.saveList(Tareas(view.text.toString()))
                mostrarProductos(Tareas(view.text.toString()))
                dialog.dismiss()
            }
            .create().show()
    }
    companion object{
        const val LISTA_PRODUCTO_CLAVE = "lista"
    }

    private fun mostrarProductos(lista:Tareas){
        val productoIntent = Intent(this,ProductosActivity::class.java)
        productoIntent.putExtra(LISTA_PRODUCTO_CLAVE,lista)
        startActivity(productoIntent)
    }

    override fun itemTapped(lista: Tareas) {
        mostrarProductos(lista)
    }
}