package com.example.mylifehackormythapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.LinearLayout
import android.util.Log
class QuizActivity : AppCompatActivity() {

    private lateinit var tvStatement: TextView
    private lateinit var tvFeedback: TextView
    private lateinit var btnHack: Button
    private lateinit var btnMyth: Button
    private lateinit var btnNext: Button

    companion object {
        val questions = listOf(
            Question(
                "Drinking more water can help you burn more calories.",
                true,
                "Staying hydrated can slightly boost metabolism and help with appetite control."
            ),
            Question(
                "Microwaving food in plastic containers is always safe.",
                false,
                "Not all plastics are microwave‑safe; some can leach harmful chemicals when heated."
            ),
            Question(
                "Brushing your teeth right after eating acidic food is the best habit.",
                false,
                "Acid softens enamel; brushing immediately can damage it. Wait 30 minutes."
            ),
            Question(
                "Eating late at night makes you gain more weight than eating the same food earlier.",
                false,
                "Weight gain is mainly about total calories, not the time of day."
            ),
            Question(
                "Stretching before a workout prevents injuries.",
                true,
                "Dynamic stretching can warm up muscles and reduce injury risk."
            )
        )
    }

    private var currentIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)
    // Removed ViewCompat.setOnApplyWindowInsetsListener that tried to cast
    // android.R.id.content to LinearLayout (which it is not), to avoid ClassCastException.

       // ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content)) { _, insets ->
           // val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
          //  findViewById<LinearLayout>(android.R.id.content).setPadding(
             //   systemBars.left,
              //  systemBars.top,
             //   systemBars.right,
              //  systemBars.bottom
          //  )
           // insets
      //  }

        tvStatement = findViewById(R.id.tvStatement)
        tvFeedback = findViewById(R.id.tvFeedback)
        btnHack = findViewById(R.id.btnHack)
        btnMyth = findViewById(R.id.btnMyth)
        btnNext = findViewById(R.id.btnNext)

        showCurrentQuestion()

        btnHack.setOnClickListener { checkAnswer(true) }
        btnMyth.setOnClickListener { checkAnswer(false) }

        btnNext.setOnClickListener {
            currentIndex++
            if (currentIndex < questions.size) {
                showCurrentQuestion()
            } else {
                Log.d("Quiz", "End of quiz; launching ScoreActivity")
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("total", questions.size)
                startActivity(intent)
            }
        }
    }

    private fun showCurrentQuestion() {
        val question = questions[currentIndex]
        tvStatement.text = question.statement
        tvFeedback.text = ""
        tvFeedback.setTextColor(Color.BLACK)
        btnHack.isEnabled = true
        btnMyth.isEnabled = true
        btnNext.isEnabled = false
    }

    private fun checkAnswer(userChoice: Boolean) {
        val question = questions[currentIndex]
        btnHack.isEnabled = false
        btnMyth.isEnabled = false
        btnNext.isEnabled = true

        if (userChoice == question.isHack) {
            tvFeedback.setTextColor(Color.GREEN)
            tvFeedback.text = "✅ Correct! That's a real time‑saver!"
            score++
        } else {
            tvFeedback.setTextColor(Color.RED)
            tvFeedback.text = "❌ Wrong! That's just an urban myth."
        }
    }
}