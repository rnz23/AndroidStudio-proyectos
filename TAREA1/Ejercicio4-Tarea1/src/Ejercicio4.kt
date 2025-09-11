/*EJERCICIO 4
Este ejercicio es un juego, donde se buscara adivinar el numero que la computadora a elegido aleatoriamente entre el 0 y el 30, dando pistas de si el número es emnor o mayor al que se inenta adivinar, pero con la condiciñon de que el usaurio solo tiene 5 oportunidades para hacerlo.
Creado por: Renzo Murillo Alvarez
Fecha de Creación: 23/08/2025
Ultima Modificación: 25/08/2025 */

import kotlin.random.Random


fun main(){
    var opcion: Int
    var intentos = 5
    val op_pc = Random.nextInt(0,31)

    do{
        print("INGRESE EL NUMERO CON EL QUE INTENTARÁ: ")
        opcion = readln().toInt()


        if(opcion > op_pc){
            println("El número a adivinar es menor... Sigue intentando")
            intentos--
            println("Le quedan: $intentos intentos..")
        }
        else if(opcion < op_pc){
            println("El numero a adivinar es mayor... Sigue intentando")
            intentos--
            println("Le quedan: $intentos intentos..")
        }
        else{
            println("FELICITACIONES GANÓ EL JUEGO")
            break
        }
        if (intentos==0){
            println("SE QUEDO SIN INTENTOS.... GAME OVER")
            println("El número era ${op_pc}")
        }
    } while (intentos > 0)


}