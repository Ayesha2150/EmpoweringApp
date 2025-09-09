package com.example.empoweringthenationapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        // Views
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val tvPhone = findViewById<TextView>(R.id.tvPhone)
        val tvSocials = findViewById<TextView>(R.id.tvSocials)
        val tvLocation = findViewById<TextView>(R.id.tvLocation)
        val btnBackHome = findViewById<Button>(R.id.btnBackHome)

        // Email action
        tvEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:info@empoweringthenation.org")
            }
            startActivity(intent)
        }

        // Phone action
        tvPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:+27 11 123 4567")
            }
            startActivity(intent)
        }

        // Location action (just shows address in text, no maps)
        tvLocation.setOnClickListener {
            // Optional: could copy to clipboard or just leave it static
        }

        // Socials action
        tvSocials.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://www.facebook.com/") // replace with your real page
            }
            startActivity(intent)
        }

        // Back button action
        btnBackHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // close ContactActivity
        }
    }
}

