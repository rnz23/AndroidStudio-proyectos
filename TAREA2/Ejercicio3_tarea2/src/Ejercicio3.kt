
/*
Descripción: Jerarquía de clases para figuras geométricas (área y perímetro).
Fecha creación: 01/09/2025
Fecha última modificación: 01/09/2025
*/

abstract class Shape {
    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double

    fun imprimirResultados() {
        println("Área: ${calcularArea()}, Perímetro: ${calcularPerimetro()}")
    }
}

class Cuadrado(val lado: Double) : Shape() {
    override fun calcularArea() = lado * lado
    override fun calcularPerimetro() = 4 * lado
}

class Rectangulo(val base: Double, val altura: Double) : Shape() {
    override fun calcularArea() = base * altura
    override fun calcularPerimetro() = 2 * (base + altura)
}

class Circulo(val radio: Double) : Shape() {
    override fun calcularArea() = Math.PI * radio * radio
    override fun calcularPerimetro() = 2 * Math.PI * radio
}

fun main() {
    val cuadrado = Cuadrado(4.0)
    val rectangulo = Rectangulo(5.0, 3.0)
    val circulo = Circulo(2.0)

    cuadrado.imprimirResultados()
    rectangulo.imprimirResultados()
    circulo.imprimirResultados()
}
