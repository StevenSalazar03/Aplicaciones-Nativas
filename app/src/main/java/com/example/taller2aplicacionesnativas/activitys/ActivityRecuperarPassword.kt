package com.example.taller2aplicacionesnativas.activitys

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taller2aplicacionesnativas.R

class ActivityRecuperarPassword : AppCompatActivity() {

    private lateinit var editTextCorreo: EditText
    private lateinit var buttonRecuperar: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperarpassword)

        editTextCorreo = findViewById(R.id.editT_correoRecuperacion)
        buttonRecuperar = findViewById(R.id.btn_recuperacion)

        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        buttonRecuperar.setOnClickListener {
            val correoIngresado = editTextCorreo.text.toString().trim()

            if (correoIngresado.isEmpty()) {
                Toast.makeText(this, "Por favor, ingrese su correo electrónico", Toast.LENGTH_SHORT).show()
            } else {
                // Verificar si el correo coincide con el registrado
                val correoRegistrado = sharedPreferences.getString("correo", "")

                if (correoIngresado == correoRegistrado) {
                    // Simular envío exitoso
                    Toast.makeText(this, "Se ha enviado un correo de recuperación a $correoIngresado", Toast.LENGTH_LONG).show()
                } else {
                    // Mostrar mensaje de error
                    Toast.makeText(this, "El correo ingresado no está registrado", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}