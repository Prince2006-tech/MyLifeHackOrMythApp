package com.example.mylifehackormythapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreActivity : AppCompatActivity() {

    private lateinit var tvScoreResult: TextView
    private lateinit var tvScoreFeedback: TextView
    private lateinit var btnReview: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)

        // WindowInsets listener removed to prevent ClassCastException
        // (android.R.id.content is not a LinearLayout)

        // Initialize UI elements from layout XML
        tvScoreResult = findViewById(R.id.tvScoreResult)
        tvScoreFeedback = findViewById(R.id.tvScoreFeedback)
        btnReview = findViewById(R.id.btnReview)

        // Retrieve score and total questions passed from QuizActivity
        val score = intent.getIntExtra("score", 0) // Default 0 if missing
        val total = intent.getIntExtra("total", 0) // Default 0 if missing

        // Display raw score
        val resultText = "You got $score out of $total correct!"
        tvScoreResult.text = resultText

        // Tiered feedback based on performance percentage
        val feedback = when {
            score >= total - 1 -> "Master Hacker!"
            score >= total * 0.5 -> "Pretty sharp! Keep going."
            else -> "Stay safe online and keep learning!"
        }
        tvScoreFeedback.text = feedback

        // Navigate to ReviewActivity for answer explanations
        btnReview.setOnClickListener {
            val intent = Intent(this, ReviewActivity::class.java)
            startActivity(intent)
        }
    }
}