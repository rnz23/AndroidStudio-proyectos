package com.example.ciclodevidaapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var contador = 0
    private lateinit var textViewContador: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewContador = findViewById(R.id.textViewContador)
        val btnAumentar = findViewById<Button>(R.id.btnAumentar)

        btnAumentar.setOnClickListener {
            contador++
            textViewContador.text = "Contador: $contador"
        }

        Log.d("CICLO", "onCreate llamado")
        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show()
    }


    // Completar esto
    override fun onStart() {
        super.onStart();
        Log.d("CICLO", "onStart llamado")

    }
    override fun onResume() {
        super.onResume();
        Log.d("CICLO", "onResume llamado")

    }
    override fun onPause() {
        super.onPause();
        Log.d("CICLO", "onPause llamado")

    }
    override fun onStop() {
        super.onStop();
        Log.d("CICLO", "onStop llamado")

    }
    override fun onDestroy() {
        super.onDestroy();
        Log.d("CICLO", "onDestroy llamado")

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Guarda el valor en objeto Bundle, para recuperarlo después.
        outState.putInt("CONTADOR", contador)
        Log.d("CICLO", "onSaveInstanceState llamado")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Recupera la información, esta es la importancia del objeto Bundle.
        contador = savedInstanceState.getInt("CONTADOR")
        textViewContador.text = "Contador: $contador"
        Log.d("CICLO","onRestoreInstanceState llamado")
    }
}
