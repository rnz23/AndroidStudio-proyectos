/* EJERCICIO1.- Crear Actividades con formulario para enviar y recibir datos de una Persona (Nombre-Edad-Ciudad-Correo)
* AUTOR: Renzo Murillo Alvarez
* Fecha de Creación: 24/09/2025
* Ultima modificación: 25/09/2025
* */
package com.example.ejercicio1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var txtName: EditText
    private lateinit var txtEdad: EditText
    private lateinit var txtCiudad: EditText
    private lateinit var txtCorreo: EditText
    private lateinit var btnContinuar: Button


    private val resumenLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if(result.resultCode == RESULT_OK){
            val mensaje = result.data?.getStringExtra("resultado")?:"Usuario registrado"
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txtName = findViewById<EditText>(R.id.txtName)
        val txtEdad = findViewById<EditText>(R.id.txtEdad)
        val txtCiudad = findViewById<EditText>(R.id.txtCiudad)
        val txtCorreo = findViewById<EditText>(R.id.txtCorreo)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)

        // Restaurar datos si se gira pantalla
        savedInstanceState?.let {
            txtName.setText(it.getString("nombre", ""))
            txtEdad.setText(it.getString("edad", ""))
            txtCiudad.setText(it.getString("ciudad", ""))
            txtCorreo.setText(it.getString("correo", ""))
        }
    }
}