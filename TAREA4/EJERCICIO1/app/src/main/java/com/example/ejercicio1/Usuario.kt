/* EJERCICIO1.- Crear Actividades con formulario para enviar y recibir datos de una Persona (Nombre-Edad-Ciudad-Correo)
* AUTOR: Renzo Murillo Alvarez
* Fecha de Creación: 24/09/2025
* Ultima modificación: 25/09/2025
* */

package com.example.ejercicio1
import java.io.Serializable

class Usuario(
    val nombre: String,
    val edad: Int,
    val ciudad: String,
    val correo: String
): Serializable