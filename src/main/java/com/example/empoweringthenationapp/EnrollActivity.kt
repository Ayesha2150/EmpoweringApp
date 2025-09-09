package com.example.empoweringthenationapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class EnrollActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enroll)

        // Views
        val etName = findViewById<TextInputEditText>(R.id.etName)
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val spinnerCourses = findViewById<Spinner>(R.id.spinnerCourses)
        val btnEnroll = findViewById<Button>(R.id.btnEnroll)
        val btnBackHome = findViewById<Button>(R.id.btnBackHome)


        // List of available courses
        val courses = arrayOf(
            "Select a course",
            "Six-Week: Child Minding - R750",
            "Six-Week: Cooking - R750",
            "Six-Week: Garden Maintenance - R750",
            "Six-Month: First Aid - R1500",
            "Six-Month: Sewing - R1500",
            "Six-Month: Landscaping - R1500"
        )

        // Set up dropdown (Spinner)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, courses)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCourses.adapter = adapter

        // Handle Enroll button
        btnEnroll.setOnClickListener {
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val course = spinnerCourses.selectedItem.toString()

            if (name.isEmpty() || email.isEmpty() || course == "Select a course") {
                Toast.makeText(this, "Please complete all fields", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "✅ $name, you are enrolled in $course!", Toast.LENGTH_LONG).show()
            }
        }

        // Handle Back to Home button
        btnBackHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // close EnrollActivity so it doesn't stay in the back stack
        }


        }
    }
