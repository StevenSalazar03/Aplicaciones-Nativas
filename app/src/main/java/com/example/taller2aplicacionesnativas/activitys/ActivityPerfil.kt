package com.example.taller2aplicacionesnativas.activitys

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.taller2aplicacionesnativas.R

class ActivityPerfil : AppCompatActivity() {

    private lateinit var textViewNombres: TextView
    private lateinit var textViewApellidos: TextView
    private lateinit var textViewCorreo: TextView
    private lateinit var textViewTelefono: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val tvFragment = findViewById<View>(R.id.btn_editar)
        tvFragment.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // Inicializar vistas
        textViewNombres = findViewById(R.id.tv_nombresP)
        textViewApellidos = findViewById(R.id.tv_apellidosP)
        textViewCorreo = findViewById(R.id.tv_correoP)
        textViewTelefono = findViewById(R.id.tv_telefonoP)

        // Recuperar los datos del Intent
        val nombres = intent.getStringExtra("NOMBRES")
        val apellidos = intent.getStringExtra("APELLIDOS")
        val correo = intent.getStringExtra("CORREO")
        val telefono = intent.getStringExtra("TELEFONO")

        // Mostrar los datos en las vistas
        textViewNombres.text = nombres
        textViewApellidos.text = apellidos
        textViewCorreo.text = correo
        textViewTelefono.text = telefono

        val botonEditar: Button = findViewById(R.id.btn_editar)
        botonEditar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("fragment_id", R.id.productosFragment)
            startActivity(intent)
        }


    }
}