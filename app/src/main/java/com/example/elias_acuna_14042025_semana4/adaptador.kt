package com.example.elias_acuna_14042025_semana4

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class adaptador(var contexto: Context,
                var datos: ArrayList<Array<String>>,
                var datosImg: ArrayList<Int>):
    BaseAdapter(){
    init {
        inflater = contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(i: Int, convertView: View?, viewGroup: ViewGroup): View{
        val vista = inflater!!.inflate(R.layout.elementos_lista, null)
        val Text_1 = vista.findViewById<View>(R.id.producto) as TextView
        val Text_2 = vista.findViewById<View>(R.id.precio) as TextView
        val imagen = vista.findViewById<View>(R.id.imagen_producto) as ImageView
        Text_1.text = datos[i][0]
        Text_2.text = datos[i] [1]
        imagen.setImageResource(datosImg[i])
        imagen.tag = i
        imagen.setOnClickListener { v ->
            val visorImagen = Intent(
                contexto,
                visor_de_imagen::class.java
            )
            visorImagen.putExtra("IMG", datosImg[(v.tag as Int)])
            visorImagen.putExtra("JUGUETE", datos[(v.tag as Int)][0])
            visorImagen.putExtra("PRECIO", datos[(v.tag as Int)][1])
            contexto.startActivity(visorImagen)
        }
        return vista
    }

    override fun getCount(): Int {
        return datosImg.size
    }

    override fun getItem(i: Int): Any? {
        return null
    }

    override fun getItemId(i: Int): Long {
        return 0
    }

    companion object {
        private var inflater:LayoutInflater? = null
    }
    fun borrarJuguete(position: Int) {
        datos.removeAt(position)
        datosImg.removeAt(position)
        notifyDataSetChanged()
    }

}