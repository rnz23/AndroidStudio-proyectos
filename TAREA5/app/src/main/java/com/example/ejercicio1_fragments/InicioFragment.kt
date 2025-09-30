/* Creación Fragment InicioFragment, primer fragment
    Autor: Renzo Josue Murillo Alvarez
    Fecha Creacion: 29-09-2025
    Ultima modificación: 30-09-2025
* */



package com.example.ejercicio1_fragments


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import android.widget.Button


class InicioFragment : Fragment(R.layout.fragment_inicio) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn_inicio = view.findViewById<Button>(R.id.btn_inicio)

        btn_inicio.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, SeleccionComidaFragment())
                addToBackStack("seleccion_comida")
                commit()
            }
        }
    }
}