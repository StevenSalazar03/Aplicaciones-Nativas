package com.example.taller2aplicacionesnativas.activitys

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.taller2aplicacionesnativas.R

class ActivityRegistro : AppCompatActivity() {

    private lateinit var editTextNombres: EditText
    private lateinit var editTextApellidos: EditText
    private lateinit var editTextCorreo: EditText
    private lateinit var editTextTelefono: EditText
    private lateinit var editTextContraseña: EditText
    private lateinit var editTextRepetirContraseña: EditText
    private lateinit var checkBoxTerminos: CheckBox
    private lateinit var buttonRegistro: Button
    private lateinit var buttonLogin: Button
    private lateinit var sharedPreferences: SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        Log.d("RegistroActivity", "OnCreate: Inicializando el activity de registro")

        // Inicializar vistas
        editTextNombres = findViewById(R.id.editT_Nombre)
        editTextApellidos = findViewById(R.id.editT_Apellido)
        editTextCorreo = findViewById(R.id.editT_Correo)
        editTextTelefono = findViewById(R.id.editT_Telefono)
        editTextContraseña = findViewById(R.id.editT_contraseña)
        editTextRepetirContraseña = findViewById(R.id.editT_RepetirContraseña)
        checkBoxTerminos = findViewById(R.id.checkbox_registro)
        buttonRegistro = findViewById(R.id.btn_registro)
        buttonLogin = findViewById(R.id.btn_login)

        // Archivo para el almacenamiento local
        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        buttonRegistro.setOnClickListener {
            // Validar campos
            if (validarCampos()) {
                // Guardar datos
                guardarDatos()

                // Redirigir a la actividad de perfil y pasar los datos
                val intent = Intent(this, ActivityPerfil::class.java).apply {
                    putExtra("NOMBRES", editTextNombres.text.toString().trim())
                    putExtra("APELLIDOS", editTextApellidos.text.toString().trim())
                    putExtra("CORREO", editTextCorreo.text.toString().trim())
                    putExtra("TELEFONO", editTextTelefono.text.toString().trim())
                }
                startActivity(intent)
                finish() // Cierra la actividad de registro
            }
        }

        buttonLogin.setOnClickListener{
            val intent = Intent(this, ActivityLogin::class.java)
            startActivity(intent)
        }
    }

    private fun validarCampos(): Boolean {
        val nombres = editTextNombres.text.toString().trim()
        val apellidos = editTextApellidos.text.toString().trim()
        val correo = editTextCorreo.text.toString().trim()
        val telefono = editTextTelefono.text.toString().trim()
        val contraseña = editTextContraseña.text.toString().trim()
        val repetirContraseña = editTextRepetirContraseña.text.toString().trim()

        if (nombres.isEmpty() || apellidos.isEmpty() || correo.isEmpty() || telefono.isEmpty() || contraseña.isEmpty() || repetirContraseña.isEmpty()) {
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            return false
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            Toast.makeText(this, "Correo electrónico no válido", Toast.LENGTH_SHORT).show()
            return false
        }

        if (contraseña != repetirContraseña) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            return false
        }

        if (!checkBoxTerminos.isChecked) {
            Toast.makeText(this, "Debes aceptar los términos y condiciones", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun guardarDatos() {
        val editor = sharedPreferences.edit()
        editor.putString("nombres", editTextNombres.text.toString().trim())
        editor.putString("apellidos", editTextApellidos.text.toString().trim())
        editor.putString("correo", editTextCorreo.text.toString().trim())
        editor.putString("telefono", editTextTelefono.text.toString().trim())
        editor.putString("contraseña", editTextContraseña.text.toString().trim())
        editor.apply()

        Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
    }
}