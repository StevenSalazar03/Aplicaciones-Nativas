package com.example.taller2aplicacionesnativas.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.taller2aplicacionesnativas.R

class EditPerfilFragment : Fragment() {

    private lateinit var tvNombres: TextView
    private lateinit var tvApellidos: TextView
    private lateinit var tvCorreo: TextView
    private lateinit var tvTelefono: TextView

    private lateinit var etNombres: EditText
    private lateinit var etApellidos: EditText
    private lateinit var etCorreo: EditText
    private lateinit var etTelefono: EditText

    private lateinit var btnEditar: Button
    private lateinit var btnGuardar: Button

    private lateinit var sharedPref: android.content.SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragments_editperfil, container, false)

        sharedPref = requireContext().getSharedPreferences("user_data", Context.MODE_PRIVATE)

        tvNombres = view.findViewById(R.id.tv_nombresP)
        tvApellidos = view.findViewById(R.id.tv_apellidosP)
        tvCorreo = view.findViewById(R.id.tv_correoP)
        tvTelefono = view.findViewById(R.id.tv_telefonoP)

        etNombres = view.findViewById(R.id.et_nombresP)
        etApellidos = view.findViewById(R.id.et_apellidosP)
        etCorreo = view.findViewById(R.id.et_correoP)
        etTelefono = view.findViewById(R.id.et_telefonoP)

        btnEditar = view.findViewById(R.id.btn_editar)
        btnGuardar = view.findViewById(R.id.btn_guardar)

        cargarDatos()

        btnEditar.setOnClickListener {
            cambiarModoEdicion(true)
        }

        btnGuardar.setOnClickListener {
            guardarDatos()
            cambiarModoEdicion(false)
        }

        return view
    }

    private fun cargarDatos() {
        val nombres = sharedPref.getString("NOMBRES", "")
        val apellidos = sharedPref.getString("APELLIDOS", "")
        val correo = sharedPref.getString("CORREO", "")
        val telefono = sharedPref.getString("TELEFONO", "")

        tvNombres.text = nombres
        tvApellidos.text = apellidos
        tvCorreo.text = correo
        tvTelefono.text = telefono

        etNombres.setText(nombres)
        etApellidos.setText(apellidos)
        etCorreo.setText(correo)
        etTelefono.setText(telefono)

        cambiarModoEdicion(false)
    }

    private fun guardarDatos() {
        val editor = sharedPref.edit()
        editor.putString("NOMBRES", etNombres.text.toString())
        editor.putString("APELLIDOS", etApellidos.text.toString())
        editor.putString("CORREO", etCorreo.text.toString())
        editor.putString("TELEFONO", etTelefono.text.toString())
        editor.apply()

        cargarDatos()
        Toast.makeText(requireContext(), "Datos actualizados correctamente", Toast.LENGTH_SHORT).show()
    }

    private fun cambiarModoEdicion(editar: Boolean) {
        val visEditar = if (editar) View.GONE else View.VISIBLE
        val visInputs = if (editar) View.VISIBLE else View.GONE

        tvNombres.visibility = visEditar
        tvApellidos.visibility = visEditar
        tvCorreo.visibility = visEditar
        tvTelefono.visibility = visEditar

        etNombres.visibility = visInputs
        etApellidos.visibility = visInputs
        etCorreo.visibility = visInputs
        etTelefono.visibility = visInputs

        btnEditar.visibility = visEditar
        btnGuardar.visibility = visInputs
    }
}
