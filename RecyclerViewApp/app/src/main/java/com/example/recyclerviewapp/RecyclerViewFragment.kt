package com.example.recyclerviewapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp.adapter.UsuarioAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecyclerViewFragment : Fragment(R.layout.fragment_recycler_view) {

    private lateinit var userAdapter: UsuarioAdapter
    private lateinit var userRecyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        initAdd()
    }

    private fun initAdd() {
        val btnAgregar = requireView().findViewById<FloatingActionButton>(R.id.btnAgregar)
        btnAgregar.setOnClickListener {
            val position = userAdapter.itemCount
            val nuevoUsuario = Usuario("Usuario $position", 20, "correo$position@gmail.com", "1234")
            userAdapter.addUser(nuevoUsuario)
            userRecyclerView.scrollToPosition(position)
        }
    }

    private fun initRecyclerView() {
        val listaUsuarios = ArrayList(UsuarioProvider.instance.listaUsuario)
        userAdapter = UsuarioAdapter(listaUsuarios)

        userRecyclerView = requireView().findViewById<RecyclerView>(R.id.recyclerViewUsuarios)

        // CONFIGURACIÓN CORREGIDA - Usa las nuevas lambdas
        userAdapter.onDeleteClick = { position ->
            userAdapter.removeUser(position)
        }

        userAdapter.onEditClick = { position, usuario ->
            userAdapter.updateUser(position, usuario)
        }

        userRecyclerView.adapter = userAdapter
        userRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        userRecyclerView.addItemDecoration(
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        )
    }
}