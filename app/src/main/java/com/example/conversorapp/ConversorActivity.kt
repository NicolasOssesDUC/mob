package com.example.conversorapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.conversorapp.funciones.convertirCelsiusAFahrenheit

class ConversorActivity : AppCompatActivity() {

    // Declaración de las vistas.
    private lateinit var etCelsius: EditText
    private lateinit var btnConvertir: Button
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor)

        // Mapeo de las vistas con el layout XML.
        etCelsius = findViewById(R.id.et_celsius)
        btnConvertir = findViewById(R.id.btn_convertir)
        tvResultado = findViewById(R.id.tv_resultado)

        // Acción del botón de conversión.
        btnConvertir.setOnClickListener {
            // Se obtiene el texto del campo de entrada.
            val celsiusInput = etCelsius.text.toString()

            // ---- MANEJO DE EXCEPCIONES: try-catch ----
            // Esto es crucial para evitar que la app se cierre si el usuario
            // ingresa datos inválidos (letras, campo vacío, etc.).
            try {
                // Se intenta ejecutar el código que podría fallar.
                val resultadoFahrenheit = convertirCelsiusAFahrenheit(celsiusInput)

                // Se formatea el resultado para mostrarlo con dos decimales.
                val resultadoFormateado = String.format("%.2f", resultadoFahrenheit)

                // Se muestra el resultado en el TextView.
                tvResultado.text = "Resultado: $resultadoFormateado °F"

            } catch (e: NumberFormatException) {
                // Esta excepción ocurre si el texto no puede convertirse a número (ej: "abc").
                tvResultado.text = "Error: Ingresa un número válido."

            } catch (e: IllegalArgumentException) {
                // Esta es la excepción que lanzamos en nuestra función si el campo está vacío.
                tvResultado.text = "Error: El campo no puede estar vacío."
            }
            // --------------------------------------------
        }
    }
}
