package com.example.elias_acuna_14042025_semana4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class visor_de_imagen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visor_de_imagen)
        val img = findViewById<View>(R.id.imagenCompleta) as ImageView
        val producto = findViewById<View>(R.id.producto) as TextView
        val precio = findViewById<View>(R.id.precio) as TextView
        val intent = intent
        val b = intent.extras
        if (b != null) {
            img.setImageResource(b.getInt("IMG"))
            producto.setText(b.getString("JUGUETE"))
            precio.setText(b.getString("PRECIO"))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.Volver -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
