package com.example.ejercicio1_fragments


import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener

class SeleccionComidaFragment : Fragment(R.layout.fragment_seleccion_comida) {

    private var comidaSeleccionada: String = ""
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroupComida)
        val btnSiguiente = view.findViewById<Button>(R.id.btn_Siguiente)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            comidaSeleccionada = when (checkedId) {
                R.id.radioPizza -> "Pizza"
                R.id.radioSalchipapa -> "Salchipapa"
                R.id.radioEnsalada -> "Ensalada"
                else -> ""
            }
        }

        btnSiguiente.setOnClickListener {
            if (comidaSeleccionada.isNotEmpty()) {
                val bundle = Bundle()
                bundle.putString("comida", comidaSeleccionada)

                val fragment = SeleccionExtrasFragment()
                fragment.arguments = bundle

                requireActivity().supportFragmentManager.beginTransaction().apply{
                    replace(R.id.fragment_container, fragment)
                    addToBackStack("seleccion_extras")
                    commit()
                }
            } else {
                Toast.makeText(requireContext(), "Selecciona un tipo de comida", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        setFragmentResultListener("pedidoActual") { requestKey, bundle ->
            if (requestKey == "pedidoActual") {
                val comida = bundle.getString("comida", "")
                when (comida) {
                    "Pizza" -> radioGroup.check(R.id.radioPizza)
                    "Salchipapa" -> radioGroup.check(R.id.radioSalchipapa)
                    "Ensalada" -> radioGroup.check(R.id.radioEnsalada)
                }
                comidaSeleccionada = comida
            }
        }
    }
}