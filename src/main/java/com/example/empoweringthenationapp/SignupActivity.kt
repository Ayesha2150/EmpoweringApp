package com.example.empoweringthenationapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        // TextInputLayouts (for showing errors)
        val layoutName = findViewById<TextInputLayout>(R.id.layoutName)
        val layoutEmail = findViewById<TextInputLayout>(R.id.layoutEmail)
        val layoutPassword = findViewById<TextInputLayout>(R.id.layoutPassword)

        // TextInputEditTexts (user input fields)
        val etName = findViewById<TextInputEditText>(R.id.etName)
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)

        // Register button
        val btnRegister = findViewById<MaterialButton>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val name = etName.text?.toString()?.trim()
            val email = etEmail.text?.toString()?.trim()
            val password = etPassword.text?.toString()?.trim()

            var isValid = true

            if (name.isNullOrEmpty()) {
                layoutName.error = "Full name is required"
                isValid = false
            } else {
                layoutName.error = null
            }

            if (email.isNullOrEmpty()) {
                layoutEmail.error = "Email is required"
                isValid = false
            } else {
                layoutEmail.error = null
            }

            if (password.isNullOrEmpty()) {
                layoutPassword.error = "Password is required"
                isValid = false
            } else if (password.length < 6) {
                layoutPassword.error = "Password must be at least 6 characters"
                isValid = false
            } else {
                layoutPassword.error = null
            }

            if (isValid) {
                // TODO: Replace with real signup logic (Firebase/Auth/DB)
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
}
