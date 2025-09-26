package com.example.ejercicio2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var txtNota: EditText
    private lateinit var btnCompartir: Button

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if (result.resultCode == Activity.RESULT_OK){
            val txtEditado = result.data?.getStringExtra("nota")
            txtNota.setText(txtEditado)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtNota = findViewById(R.id.txtNota)
        btnCompartir = findViewById(R.id.btnCompartir)

        savedInstanceState?.let {
            txtNota.setText(it.getString("nota_guardada"))
        }

        btnCompartir.setOnClickListener {
            val texto = txtNota.text.toString()
            val intent = Intent(this, CompartirActivity::class.java)
            intent.putExtra("nota",texto)
            launcher.launch(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("nota_guaradada",txtNota.text.toString())
    }
}