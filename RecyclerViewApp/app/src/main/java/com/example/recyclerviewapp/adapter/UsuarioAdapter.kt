package com.example.recyclerviewapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewapp.Usuario
import com.example.recyclerviewapp.R

class UsuarioAdapter(var items: ArrayList<Usuario>): RecyclerView.Adapter<UsuarioViewHolder>() {

    var onEditClick: ((Int, Usuario) -> Unit)? = null
    var onDeleteClick: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_usuario, parent, false)
        return UsuarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val user = items[position]
        holder.bind(user) { pos ->
            onDeleteClick?.invoke(pos)
        }

        // Agregar long click manualmente
        holder.itemView.setOnLongClickListener {
            // Aquí deberías mostrar el diálogo de opciones
            // Pero necesitarías acceso al context para crear el AlertDialog
            true
        }
    }

    override fun getItemCount(): Int = items.size

    fun addUser(user: Usuario) {
        items.add(user)
        notifyItemInserted(itemCount - 1)
    }

    fun removeUser(position: Int) {
        items.removeAt(position)
        notifyItemRemoved(position)
    }

    fun updateUser(position: Int, usuario: Usuario) {
        items[position] = usuario
        notifyItemChanged(position)
    }
}