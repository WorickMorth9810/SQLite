package com.example.intenciones_angls

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_agregar_producto.*

class AgregarProducto : AppCompatActivity() {
    lateinit var text1: EditText
    lateinit var text2: EditText
    lateinit var text3: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_producto)

        text1 = findViewById(R.id.edText1)
        text2 = findViewById(R.id.edText2)
        text3 = findViewById(R.id.edText3)
        val btnsalir=this.BtnSalir

        btnsalir.setOnClickListener {
            finish()
        }
    }
    override fun onResume() {
        super.onResume()
        mostrarDatos()

    }
    fun mostrarDatos(){
        val db= Room.databaseBuilder(applicationContext, AppBaseDatos::class.java,"productos")
            .allowMainThreadQueries().build()
        val productos= db.productoDao().todosProductos()

        Log.e("DATOS","Productos:${productos.size}")
        productos.forEach { x ->
            Log.e("DATOS", "${x.id} ${x.nombre} ${x.precio}")
        }
    }

    fun grabarProducto(v: View){
        val id= text1.text.toString().toInt()
        val nombre= text2.text.toString()
        val precio= text3.text.toString().toDouble()
        //limpiar los campos
        text1.setText("")
        text2.setText("")
        text3.setText("")
        //
        val producto = Producto(id,nombre,precio)
        val db= Room.databaseBuilder(applicationContext, AppBaseDatos::class.java,"productos")
            .allowMainThreadQueries().build()
        db.productoDao().agregarProducto(producto) //insert
        Snackbar.make(v, "Se grabo", Snackbar.LENGTH_LONG).show()
        mostrarDatos()
    }
}