
/*
Descripción: Clase para manejar una cuenta bancaria con saldo y límite de retiro.
Fecha creación: 01/09/2025
Fecha última modificación: 02/09/2025
*/

class CuentaBancaria(private var _saldo: Double, private var _limiteRetiro: Double) {

    var saldo: Double = _saldo
        private set(value) {
            require(value >= 0) { "El saldo no puede ser negativo" }
            field = value
        }
        get() = field

    var limiteRetiro: Double = _limiteRetiro
        set(value) {
            require(value > 0) { "El límite de retiro debe ser mayor a 0" }
            field = value
        }

    fun retirar(monto: Double) {
        require(monto > 0) { "El monto debe ser positivo" }
        if (monto > limiteRetiro) {
            println("El monto excede el límite de retiro")
        } else if (monto > saldo) {
            println("Fondos insuficientes")
        } else {
            saldo -= monto
            println("Retiro exitoso. Nuevo saldo: $saldo")
        }
    }
}

fun main() {
    val cuenta = CuentaBancaria(1000.0, 500.0)
    cuenta.retirar(300.0)
    cuenta.retirar(700.0)
    cuenta.retirar(600.0)
}