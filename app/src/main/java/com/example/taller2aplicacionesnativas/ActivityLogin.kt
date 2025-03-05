package com.example.taller2aplicacionesnativas

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ActivityLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Configurar OnClickListener para "Recuperar Contraseña"
        val tvRecuperarContraseña = findViewById<View>(R.id.recuperarContraseña)
        tvRecuperarContraseña.setOnClickListener {
            val intent = Intent(this, ActivityRecuperarPassword::class.java)
            startActivity(intent)
        }

        // Configurar OnClickListener para "Registrarse"
        val tvRegistrarse = findViewById<View>(R.id.textRegistro2)
        tvRegistrarse.setOnClickListener {
            val intent = Intent(this, ActivityRegistro::class.java)
            startActivity(intent)
        }
    }
}