package com.example.mylifehackormythapp

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent
class ReviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val btnRetry: Button = findViewById(R.id.btnRetry)
        btnRetry.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()  // Optional: closes current screen to prevent back stack issues
        }

        val container = findViewById<LinearLayout>(R.id.containerReviews)

        QuizActivity.questions.forEach { question ->
            val item = layoutInflater.inflate(R.layout.item_review, container, false) as LinearLayout

            val tvStatement = item.findViewById<TextView>(R.id.tvReviewStatement)
            val tvAnswer = item.findViewById<TextView>(R.id.tvReviewAnswer)
            val tvExplanation = item.findViewById<TextView>(R.id.tvReviewExplanation)

            tvStatement.text = question.statement
            tvAnswer.text = if (question.isHack) "Answer: Hack (True)" else "Answer: Myth (False)"
            tvExplanation.text = "Explanation: ${question.explanation}"

            container.addView(item)
        }
    }
}