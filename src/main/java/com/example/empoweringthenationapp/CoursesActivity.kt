package com.example.empoweringthenationapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class CoursesActivity : AppCompatActivity() {

    private lateinit var layoutCourseDetails: LinearLayout
    private lateinit var btnSixWeek: Button
    private lateinit var btnSixMonth: Button
    private lateinit var btnBackHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        layoutCourseDetails = findViewById(R.id.layoutCourseDetails)
        btnSixWeek = findViewById(R.id.btnSixWeek)
        btnSixMonth = findViewById(R.id.btnSixMonth)
        btnBackHome = findViewById(R.id.btnBackHome)

        btnSixWeek.setOnClickListener { showSixWeekCourses() }
        btnSixMonth.setOnClickListener { showSixMonthCourses() }
        btnBackHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    data class Course(
        val name: String,
        val price: String,
        val description: List<String>,
        val imageResId: Int
    )

    private fun showSixWeekCourses() {
        layoutCourseDetails.removeAllViews()
        val courses = listOf(
            Course(
                "Child Minding",
                "R750",
                listOf("Toddler needs","Birth to sic month old baby needs", "Educational toys", "Seven month to one year old needs"),
                R.drawable.child // replace with your image
            ),
            Course(
                "Cooking",
                "R750",
                listOf("nutritious meals","Types of protein,carbohydrates and vegetables", "Kitchen safety","Preparation and cooking meals" ,"Meal planning"),
                R.drawable.cooking // replace with your image
            ),
            Course(
                "Garden Maintenance",
                "R750",
                listOf("Watering restrictions and the watering requirements of indegenous plants and exotix plants", "Pruning and progration of plants", "Planting techniques for different plants types "),
                R.drawable.garden // replace with your image
            )
        )
        courses.forEach { layoutCourseDetails.addView(createCourseCard(it)) }
    }

    private fun showSixMonthCourses() {
        layoutCourseDetails.removeAllViews()
        val courses = listOf(
            Course(
                "First Aid",
                "R1500",
                listOf("First aid awareness", "Basic life support"),
                R.drawable.firstaid
            ),
            Course(
                "Sewing",
                "R1500",
                listOf("Types of stitches","Alterations","Designing and sewing new garmets","Treading a sewing machine", "Sewing buttons,zips,hems and seams"),
                R.drawable.sewing
            ),
            Course(
                "Landscaping",
                "R1500",
                listOf("Garden Layout","Aesthetics of plants shapes and colors","Balancing of plants and trees in a garden", "Fixed structures", "Indegenous and exotic plants and trees"),
                R.drawable.landscapping
            ),
            Course(
                "Life Skills",
                "R1500",
                listOf("Basic numeric literacy","Open a bank account" ,"Basic Labour law", "Basic reading and writing literacy(KNOW YOUR RIGHTS)"),
                R.drawable.lifeskills
            )
        )
        courses.forEach { layoutCourseDetails.addView(createCourseCard(it)) }
    }

    private fun createCourseCard(course: Course): CardView {
        val card = CardView(this).apply {
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(0, 16, 0, 16)
            layoutParams = params
            radius = 16f
            cardElevation = 6f
            setContentPadding(16, 16, 16, 16)
            setCardBackgroundColor(Color.WHITE)
        }

        val horizontalLayout = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }

        val image = ImageView(this).apply {
            setImageResource(course.imageResId)
            layoutParams = LinearLayout.LayoutParams(150, 150).apply {
                setMargins(0, 0, 16, 0)
            }
            scaleType = ImageView.ScaleType.CENTER_CROP
        }

        val verticalLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
        }

        val tvName = TextView(this).apply {
            text = course.name
            textSize = 18f
            setTextColor(Color.BLACK)
            setTypeface(null, android.graphics.Typeface.BOLD)
        }

        val tvPrice = TextView(this).apply {
            text = course.price
            textSize = 16f
            setTextColor(Color.DKGRAY)
        }

        val tvDescription = TextView(this).apply {
            text = course.description.joinToString(separator = "\n") { "• $it" }
            textSize = 14f
            setTextColor(Color.DKGRAY)
            setPadding(0, 4, 0, 0)
        }

        verticalLayout.addView(tvName)
        verticalLayout.addView(tvPrice)
        verticalLayout.addView(tvDescription)

        horizontalLayout.addView(image)
        horizontalLayout.addView(verticalLayout)
        card.addView(horizontalLayout)

        return card
    }
}
