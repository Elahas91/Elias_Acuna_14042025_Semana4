package com.example.elias_acuna_14042025_semana4

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ListView


class MainActivity : AppCompatActivity() {

    var Lista: ListView? = null
    var datos = arrayListOf(
        arrayOf("Soldado", "$5000 pesos"),
        arrayOf("Caballo", "$10000 pesos"),
        arrayOf("Castillo", "$25000 pesos"),
        arrayOf("")
    )

    var datosImg = arrayListOf(R.drawable.soldado, R.drawable.caballo, R.drawable.castillo)
    private lateinit var adaptador: adaptador
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Lista = findViewById<View>(R.id.principal) as ListView
        adaptador = adaptador(this, datos, datosImg)
        Lista!!.adapter = adaptador
        registerForContextMenu(Lista)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater =menuInflater
        val info = menuInfo as AdapterContextMenuInfo
        inflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterContextMenuInfo
        val position = info.position
        return when (item.itemId){
            R.id.borrar -> {
                adaptador.borrarJuguete(info.position)
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}