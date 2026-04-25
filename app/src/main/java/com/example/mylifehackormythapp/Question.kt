package com.example.mylifehackormythapp


 // Data class representing a single quiz question.
 // Holds statement text, correct answer flag, and explanation.

data class Question(
    val statement: String, // Question/life hack statement to display
    val isHack: Boolean,  // true = hack, false = myth (correct answer)
    val explanation: String // Detailed answer explanation for review
)