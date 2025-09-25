package com.example.ejercicio1

import android.app.Activity
import android.os.Bundle
import android.content.Intent
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import android.widget.Button


class ResumenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        val txtResumen = findViewById<TextView>(R.id.txtResumen)
        val btnConfirmmar = findViewById<Button>(R.id.btnConfirmar)
        val btnEditar = findViewById<Button>(R.id.btnEditar)

        val nombre = intent.getStringExtra("nombre")
        val edad = intent.getStringExtra("edad")
        val ciudad = intent.getStringExtra("ciudad")
        val correo = intent.getStringExtra("correo")

        txtResumen.text = buildString {
            append("Nombre: $nombre\n")
            append("Edad: $edad\n")
            append("Ciudad: $ciudad\n")
            append("Correo: $correo")
        }

        btnConfirmmar.setOnClickListener {
            val resultIntent = Intent().apply{
                putExtra("resultado","registro confirmado")
            }
            setResult(Activity.RESULT_OK,resultIntent)
            finish()
        }

        btnEditar.setOnClickListener {
            val resultIntent = Intent().apply {
                putExtra("resultado","Solicito Edicion")
            }
            setResult(Activity.RESULT_OK,resultIntent)
            finish()
        }
    }
}

