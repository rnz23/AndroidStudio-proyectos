package com.example.ejercicio2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CompartirActivity : AppCompatActivity() {

    private lateinit var verNota : TextView
    private lateinit var btnCorreo : Button
    private lateinit var btnEditar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compartir)

        verNota = findViewById(R.id.verNota)
        btnCorreo = findViewById(R.id.btnCorreo)
        btnEditar = findViewById(R.id.btnEditar)

        val nota = intent.getStringExtra("nota")?:""
        verNota.text=nota

        btnCorreo.setOnClickListener {
            Toast.makeText(this,"Compartido por correo",Toast.LENGTH_SHORT).show()
        }
        btnEditar.setOnClickListener {
            val intent = Intent().apply{
                putExtra("nota",nota)
            }
            setResult(Activity.RESULT_OK,intent)
            finish()
        }


    }
}