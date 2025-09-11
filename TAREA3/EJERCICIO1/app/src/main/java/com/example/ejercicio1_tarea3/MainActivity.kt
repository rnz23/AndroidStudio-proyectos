package com.example.ejercicio1_tarea3

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.ImageView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // referencias a las vistas
        val txtNombre = findViewById<EditText>(R.id.txtNombre)
        val btnSaludar = findViewById<Button>(R.id.btnSaludar)
        val lblResult = findViewById<TextView>(R.id.lblResult)
        val Img_btn = findViewById<ImageView>(R.id.Img_btn)


        btnSaludar.setOnClickListener {
            val nombre = txtNombre.text.toString()
            if (nombre.isNotEmpty()){
                val mensaje = "Hola, $nombre"
                lblResult.text=mensaje
            }
            else {
                Toast.makeText(this, "Escribe tu nombre", Toast.LENGTH_LONG).show()

            }
        }

        Img_btn.setOnClickListener {
            Toast.makeText(this,"Hiciste click en la imagen", Toast.LENGTH_SHORT).show()
        }




    }
}