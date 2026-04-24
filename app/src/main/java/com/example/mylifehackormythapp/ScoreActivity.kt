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

        // Removed ViewCompat.setOnApplyWindowInsetsListener that tried to cast
        // android.R.id.content to LinearLayout (which it is not), to avoid ClassCastException.

        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { _, insets ->
            //val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
           // findViewById<LinearLayout>(android.R.id.content).setPadding(
            //    systemBars.left,
               // systemBars.top,
             //   systemBars.right,
               // systemBars.bottom
           // )
           // insets
       // }

        tvScoreResult = findViewById(R.id.tvScoreResult)
        tvScoreFeedback = findViewById(R.id.tvScoreFeedback)
        btnReview = findViewById(R.id.btnReview)

        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)

        val resultText = "You got $score out of $total correct!"
        tvScoreResult.text = resultText

        val feedback = when {
            score >= total - 1 -> "Master Hacker!"
            score >= total * 0.5 -> "Pretty sharp! Keep going."
            else -> "Stay safe online and keep learning!"
        }
        tvScoreFeedback.text = feedback

        btnReview.setOnClickListener {
            val intent = Intent(this, ReviewActivity::class.java)
            startActivity(intent)
        }
    }
}