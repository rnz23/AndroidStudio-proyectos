/*
Descripción: Clase Producto con precio, descuento y cálculo de precio final.
Fecha creación: 01/09/2025
Fecha última modificación: 01/09/2025
*/

class Producto(private var _precio: Double, private var _descuento: Double) {

    var precio: Double = _precio
        set(value) {
            require(value >= 0) { "El precio no puede ser negativo" }
            field = value
        }

    var descuento: Double = _descuento
        set(value) {
            require(value in 0.0..100.0) { "El descuento debe estar entre 0% y 100%" }
            field = value
        }

    fun precioFinal(): Double {
        return precio - (precio * descuento / 100)
    }
}

fun main() {
    val prod = Producto(200.0, 15.0)
    println("Precio final: ${prod.precioFinal()}")
}