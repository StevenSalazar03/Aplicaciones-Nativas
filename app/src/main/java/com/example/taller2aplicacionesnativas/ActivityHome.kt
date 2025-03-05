package com.example.taller2aplicacionesnativas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val btnComenzar = findViewById<Button>(R.id.btn_comenzar)
        btnComenzar.setOnClickListener {
            // Redirigir a la actividad de Login
            val intent = Intent(this, ActivityLogin::class.java)
            startActivity(intent)
        }

        // Inicializar el TextView "Regístrate"
        val textRegistro = findViewById<TextView>(R.id.text_registro)
        textRegistro.setOnClickListener {
            // Redirigir a la actividad de Registro
            val intent = Intent(this, ActivityRegistro::class.java)
            startActivity(intent)
        }
    }
}