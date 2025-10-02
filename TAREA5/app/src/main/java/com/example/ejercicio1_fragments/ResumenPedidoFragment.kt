package com.example.ejercicio1_fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.fragment.app.setFragmentResult

class ResumenPedidoFragment : Fragment(R.layout.fragment_resumen_pedido) {

    // Obtener argumentos de forma segura
    private val args: ResumenPedidoFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mostrarResumenPedido(view)
        configurarBotones(view)
    }

    private fun mostrarResumenPedido(view: View) {
        val comida = args.comida
        val extras = args.extras

        val txtComida = view.findViewById<TextView>(R.id.txtComida)
        val txtExtras = view.findViewById<TextView>(R.id.txtExtras)

        txtComida.text = "Comida: $comida"
        txtExtras.text = "Extras: $extras"
    }

    private fun configurarBotones(view: View) {
        val btnConfirmar = view.findViewById<Button>(R.id.btnConfirmarPedido)
        val btnEditar = view.findViewById<Button>(R.id.btnEditarPedido)

        btnConfirmar.setOnClickListener {
            confirmarPedido()
        }

        btnEditar.setOnClickListener {
            editarPedido()
        }
    }

    private fun confirmarPedido() {
        val comida = args.comida
        val extras = args.extras

        Toast.makeText(
            requireContext(),
            "Pedido confirmado: $comida con $extras",
            Toast.LENGTH_LONG
        ).show()

        // Navegar al inicio limpiando el back stack - FORMA CORRECTA con Navigation
        findNavController().popBackStack(R.id.inicioFragment, false)
    }

    private fun editarPedido() {
        val comida = args.comida

        // Enviar datos actuales al fragment anterior usando fragment result
        val bundle = Bundle().apply {
            putString("comida", comida)
        }
        setFragmentResult("pedidoActual", bundle)

        // Regresar al fragmento de selección de comida usando Navigation
        findNavController().navigate(R.id.action_resumenPedidoFragment_to_seleccionComidaFragment)
    }
}