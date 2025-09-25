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
    }
}