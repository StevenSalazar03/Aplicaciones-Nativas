package com.example.taller2aplicacionesnativas.activitys

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.taller2aplicacionesnativas.R

class ActivityLogin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val tvRecuperarContraseña = findViewById<View>(R.id.recuperarContraseña)
        tvRecuperarContraseña.setOnClickListener {
            val intent = Intent(this, ActivityRecuperarPassword::class.java)
            startActivity(intent)
        }
        val tvIngresar = findViewById<View>(R.id.btn_ingreso)
        tvIngresar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        val tvRegistrarse = findViewById<View>(R.id.textRegistro2)
        tvRegistrarse.setOnClickListener {
            val intent = Intent(this, ActivityRegistro::class.java)
            startActivity(intent)
        }
    }
}