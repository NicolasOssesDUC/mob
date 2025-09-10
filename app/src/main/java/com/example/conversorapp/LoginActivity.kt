package com.example.conversorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    // Se declaran las vistas que se van a usar.
    private lateinit var etUsuario: EditText
    private lateinit var etContrasena: EditText
    private lateinit var btnIngresar: Button
    private lateinit var tvMensajeError: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Se mapean las variables con los IDs del layout XML usando findViewById.
        etUsuario = findViewById(R.id.et_usuario)
        etContrasena = findViewById(R.id.et_contrasena)
        btnIngresar = findViewById(R.id.btn_ingresar)
        tvMensajeError = findViewById(R.id.tv_mensaje_error)

        // Se define la acción que ocurrirá al presionar el botón.
        btnIngresar.setOnClickListener {
            // Se obtienen los textos de los campos.
            val usuario = etUsuario.text.toString()
            val contrasena = etContrasena.text.toString()

            // Credenciales "hardcodeadas" (fijas en el código) para la validación.
            val usuarioValido = "admin"
            val contrasenaValida = "1234"

            // Se comprueba si el usuario y la contraseña son correctos.
            if (usuario == usuarioValido && contrasena == contrasenaValida) {
                // Si son correctos, se limpia el mensaje de error.
                tvMensajeError.text = ""

                // Se crea un Intent para abrir la siguiente pantalla (ConversorActivity).
                val intent = Intent(this, ConversorActivity::class.java)
                startActivity(intent)

                // Opcional: finaliza esta actividad para que el usuario no pueda volver atrás.
                finish()

            } else {
                // Si son incorrectos, se muestra un mensaje de error.
                tvMensajeError.text = "Usuario o contraseña incorrectos."
            }
        }
    }
}
