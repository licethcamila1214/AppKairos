package com.example.kairos.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.activity.enableEdgeToEdge
import com.example.kairos.R
import com.google.android.material.button.MaterialButton
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ===== REFERENCIAS A LOS COMPONENTES =====
        val etUsuario  = findViewById<EditText>(R.id.etUsuario)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnIngresar  = findViewById<MaterialButton>(R.id.btnIngresar)
        val btnGoogle    = findViewById<MaterialButton>(R.id.btnGoogle)
        val tvRecuperar  = findViewById<TextView>(R.id.tvRecuperar)
        val tvRegistrate = findViewById<TextView>(R.id.tvRegistrate)

        // ===== BOTÓN INGRESAR =====
        btnIngresar.setOnClickListener {
            val usuario = etUsuario.text.toString().trim()
            val password = etPassword.text.toString().trim()

            when {
                usuario.isEmpty() -> {
                    Toast.makeText(this, "Por favor ingresa tu usuario", Toast.LENGTH_SHORT).show()
                }
                password.isEmpty() -> {
                    Toast.makeText(this, "Por favor ingresa tu contraseña", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    // ✅ Aquí va tu lógica de autenticación (Firebase, API, etc.)
                    Toast.makeText(this, "¡Bienvenido a KAIROS!", Toast.LENGTH_SHORT).show()
                    // startActivity(Intent(this, MainActivity::class.java))
                    // finish()
                }
            }
        }

        // ===== BOTÓN GOOGLE =====
        btnGoogle.setOnClickListener {
            // ✅ Aquí va la lógica de Google Sign-In
            Toast.makeText(this, "Ingresando con Google...", Toast.LENGTH_SHORT).show()
        }

        // ===== RECUPERAR CONTRASEÑA =====
        tvRecuperar.setOnClickListener {
            // ✅ Aquí va tu pantalla de recuperación
            Toast.makeText(this, "Recuperar contraseña", Toast.LENGTH_SHORT).show()
            // startActivity(Intent(this, RecuperarActivity::class.java))
        }

        // ===== REGISTRARSE =====
        tvRegistrate.setOnClickListener {
            // ✅ Aquí va tu pantalla de registro
            Toast.makeText(this, "Ir a registro", Toast.LENGTH_SHORT).show()
            // startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}