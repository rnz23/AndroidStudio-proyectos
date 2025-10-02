package com.example.ejercicio1_fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class SeleccionExtrasFragment : Fragment(R.layout.fragment_seleccion_extras) {

    // Obtener argumentos de forma segura con Safe Args
    private val args: SeleccionExtrasFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnSiguiente = view.findViewById<Button>(R.id.btnSiguienteExtras)

        btnSiguiente.setOnClickListener {
            val extras = obtenerExtrasSeleccionados(view)
            navegarAResumenPedido(extras)
        }
    }

    private fun obtenerExtrasSeleccionados(view: View): String {
        val opBebida = view.findViewById<CheckBox>(R.id.opBebida)
        val opPapas = view.findViewById<CheckBox>(R.id.opPapas)
        val opPostre = view.findViewById<CheckBox>(R.id.opPostre)

        val extras = mutableListOf<String>()
        if(opBebida.isChecked) extras.add("Bebida")
        if(opPapas.isChecked) extras.add("Papas")
        if(opPostre.isChecked) extras.add("Postre")
        return if(extras.isEmpty()) "Sin Extras" else extras.joinToString(", ")
    }

    private fun navegarAResumenPedido(extras: String) {
        // Obtener la comida de los argumentos de forma segura
        val comida = args.comida

        // Navegar con Navigation Component y Safe Args
        val action = SeleccionExtrasFragmentDirections.actionSeleccionExtrasFragmentToResumenPedidoFragment(comida, extras)
        findNavController().navigate(action)
    }
}