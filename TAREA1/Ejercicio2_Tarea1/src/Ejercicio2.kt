/*EJERCICIO 2
Este ejercicio es un juego de piedra, papel o tijeras, donde el usuario se enfrentará a la PC, al final se imprimirá si el usuario empató, perdió o ganó.
Creado por: Renzo Murillo Alvarez
Fecha de Creación: 23/08/2025
Ultima Modificación: 25/08/2025 */

import kotlin.random.Random



fun juego(opcion: Int, op_pc:Int):String{
    return when{
        opcion == op_pc -> "EMPATE"
        opcion == 1 && op_pc == 2 ->"GANASTE"
        opcion == 2 && op_pc == 3 ->"GANASTE"
        opcion == 3 && op_pc == 1 -> "GANASTE"
        else -> "PERDISTE"


    }
}


fun opciones(opcion:Int): String{
    return when(opcion) {
        1-> "PAPEL"
        2-> "PIEDRA"
        3-> "TIJERA"
        else -> "OPCION INVALIDA"
    }
}




fun main(){
    println("PIEDRA - PAPEL - TIJERA")
    println("Ingresa la opcion que desee jugar: ")
    println("1) Papel")
    println("2) Piedra")
    println("3) Tijera")
    println("SOLO INGRESE 1 - 2 - 3")
    val opcion = readln().toInt()
    val op_pc = Random.nextInt(1,4)


    if (opcion <1 || opcion > 3){
        println("Opcion invalida, debe ser entre 1 y 3")
        return
    }
    println("TU ELEGISTE ${opciones(opcion)}")
    println("PC ELIGIO ${opciones(op_pc)}")


    val resultado =juego(opcion, op_pc)
    println("RESULTADO: $resultado")
}