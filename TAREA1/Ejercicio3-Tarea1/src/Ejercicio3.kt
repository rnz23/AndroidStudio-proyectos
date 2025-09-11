/*EJERCICIO 3
Este ejercicio es una "calculadora elemental" donde tnedran las operaciones básicas, suma, resta, multiplicación, division y la opcion de salir. En caso se seleccione una opcion invalida se mandara un mensaje de advertencia.
Creado por: Renzo Murillo Alvarez
Fecha de Creación: 23/08/2025
Ultima Modificación: 25/08/2025 */

fun mostrarmenu(){
    println("=====MENU CALCULADORA=====")
    println(" 1. SUMA ")
    println(" 2. RESTA ")
    println(" 3. MULTIPLICACION ")
    println(" 4. DIVISION ")
    println(" 5. SALIR ")
}
fun leer():Pair<Double, Double>{
    print("Ingrese el primer numero: ")
    val num1 = readln().toDouble()
    print("Ingrese el segundo numero: ")
    val num2 = readln().toDouble()
    return Pair(num1,num2)
}
fun main (){
    var opcion: Int


    do{
        mostrarmenu()
        print("INGRESE SU OPCION: ")
        opcion = readln().toInt()
        when (opcion){
            1->{
                println("---SUMA---")
                val(x,y) = leer()
                println("Resultado: ${x+y}")
            }
            2->{
                println("---RESTA---")
                val(x,y) = leer()
                println("Resultado: ${x-y}")
            }
            3->{
                println("---MULTIPLICACION---")
                val(x,y) = leer()
                println("Resultado: ${x*y}")
            }
            4->{
                println("---DIVISION---")
                val(x,y) = leer()
                println("Resultado: ${x/y}")
            }
            5->{
                println("---SALIENDO DEL PROGRAMA...---")
            }
            else -> println("Opcion invalida")


        }
    } while (opcion !=5)
}