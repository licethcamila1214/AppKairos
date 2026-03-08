package com.example.kairos.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kairos.R
import com.google.android.material.button.MaterialButton

class RegisterActivity : AppCompatActivity() {

    // ===== VIEWS =====
    private lateinit var etNombres: EditText
    private lateinit var etApellidos: EditText
    private lateinit var etCorreo: EditText
    private lateinit var etPassword: EditText
    private lateinit var etRepeatPassword: EditText
    private lateinit var cbTerminos: CheckBox
    private lateinit var btnRegistro: MaterialButton
    private lateinit var tvVolverLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // ===== CONECTAR VIEWS =====
        etNombres        = findViewById(R.id.etNombres)
        etApellidos      = findViewById(R.id.etApellidos)
        etCorreo         = findViewById(R.id.etCorreo)
        etPassword       = findViewById(R.id.etPassword)
        etRepeatPassword = findViewById(R.id.etRepeatPassword)
        cbTerminos       = findViewById(R.id.cbTerminos)
        btnRegistro      = findViewById(R.id.btnRegistro)
        tvVolverLogin    = findViewById(R.id.tvVolverLogin)

        // ===== BOTÓN REGISTRO =====
        btnRegistro.setOnClickListener {
            if (validarCampos()) {
                Toast.makeText(this, "¡Formulario válido!", Toast.LENGTH_SHORT).show()
            }
        }

        // ===== VOLVER AL LOGIN =====
        tvVolverLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    // ===== VALIDACIONES =====
    private fun validarCampos(): Boolean {
        val nombres   = etNombres.text.toString().trim()
        val apellidos = etApellidos.text.toString().trim()
        val correo    = etCorreo.text.toString().trim()
        val password  = etPassword.text.toString()
        val repeat    = etRepeatPassword.text.toString()

        if (nombres.isEmpty()) {
            etNombres.error = "Ingresa tus nombres"
            etNombres.requestFocus()
            return false
        }
        if (apellidos.isEmpty()) {
            etApellidos.error = "Ingresa tus apellidos"
            etApellidos.requestFocus()
            return false
        }
        if (correo.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            etCorreo.error = "Ingresa un correo válido"
            etCorreo.requestFocus()
            return false
        }
        if (password.length < 6) {
            etPassword.error = "Mínimo 6 caracteres"
            etPassword.requestFocus()
            return false
        }
        if (password != repeat) {
            etRepeatPassword.error = "Las contraseñas no coinciden"
            etRepeatPassword.requestFocus()
            return false
        }
        if (!cbTerminos.isChecked) {
            Toast.makeText(this, "Debes aceptar los términos y condiciones", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}