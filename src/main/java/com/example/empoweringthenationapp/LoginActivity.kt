package com.example.empoweringthenationapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Username & Password fields (TextInputEditText inside TextInputLayout)
        val etUsername = findViewById<TextInputEditText>(R.id.etUsername)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnSignup = findViewById<Button>(R.id.btnSignup)

        btnLogin.setOnClickListener {
            val username = etUsername.text?.toString()?.trim()
            val password = etPassword.text?.toString()?.trim()

            if (username.isNullOrEmpty()) {
                etUsername.error = "Username required"
                return@setOnClickListener
            }

            if (password.isNullOrEmpty()) {
                etPassword.error = "Password required"
                return@setOnClickListener
            }

            // TODO: Replace with real authentication later
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        btnSignup.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }
}
