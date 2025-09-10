package com.example.conversorapp.funciones

// Este archivo contiene la lógica de negocio para las conversiones.

/**
 * Convierte un valor de grados Celsius a Fahrenheit.
 * Se usa un 'if' para una validación simple, como se solicitó.
 *
 * @param celsiusStr El valor en grados Celsius como un String.
 * @return El valor convertido a Fahrenheit como Double.
 * @throws NumberFormatException si el String no es un número válido.
 */
fun convertirCelsiusAFahrenheit(celsiusStr: String): Double {
    // Se comprueba con un 'if' que el campo no esté vacío, como ejemplo de validación.
    if (celsiusStr.isBlank()) {
        // Lanza una excepción personalizada o estándar si el campo está vacío.
        throw IllegalArgumentException("El campo de Celsius no puede estar vacío.")
    }

    // El bloque try-catch para la conversión se manejará en la Activity,
    // pero la conversión en sí se hace aquí.
    val celsius = celsiusStr.toDouble()

    // Fórmula de conversión
    return (celsius * 9 / 5) + 32
}
