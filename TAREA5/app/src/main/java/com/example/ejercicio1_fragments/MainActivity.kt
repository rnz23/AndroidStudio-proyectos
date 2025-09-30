/* Aplicacion con fragments
    Autor: Renzo Josue Murillo Alvarez
    Fecha Creacion: 29-09-2025
    Ultima modificación: 30-09-2025
* */


package com.example.ejercicio1_fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragment_container, InicioFragment())
            commit()
        }

    }
}