package com.example.mylifehackormythapp

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ReviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

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