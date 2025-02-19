package com.budzen

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {
    private lateinit var questionText: TextView
    private lateinit var option1: Button
    private lateinit var option2: Button
    private lateinit var option3: Button
    private lateinit var option4: Button
    private lateinit var nextButton: Button

    private val questions = listOf(
        QuizQuestion("What is a good credit score?", listOf("200", "500", "700", "300"), 2),
        QuizQuestion("What is the 50/30/20 budgeting rule?", listOf(
            "50% needs, 30% wants, 20% savings",
            "50% savings, 30% needs, 20% wants",
            "50% rent, 30% groceries, 20% fun",
            "50% bills, 50% savings"
        ), 0)
    )

    private var currentQuestionIndex = 0
    private var selectedAnswerIndex = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        questionText = findViewById(R.id.tvQuestion)
        option1 = findViewById(R.id.btnOption1)
        option2 = findViewById(R.id.btnOption2)
        option3 = findViewById(R.id.btnOption3)
        option4 = findViewById(R.id.btnOption4)
        nextButton = findViewById(R.id.btnNext)

        loadQuestion()

        val buttons = listOf(option1, option2, option3, option4)
        for (i in buttons.indices) {
            buttons[i].setOnClickListener {
                selectedAnswerIndex = i
                highlightSelectedAnswer(buttons, i)
            }
        }

        nextButton.setOnClickListener {
            if (selectedAnswerIndex == -1) return@setOnClickListener

            if (selectedAnswerIndex == questions[currentQuestionIndex].correctAnswer) {
                nextButton.text = "Correct! Next"
                nextButton.setBackgroundColor(Color.GREEN)
            } else {
                nextButton.text = "Wrong! Try Again"
                nextButton.setBackgroundColor(Color.RED)
            }

            nextButton.setOnClickListener {
                if (currentQuestionIndex < questions.size - 1) {
                    currentQuestionIndex++
                    loadQuestion()
                    resetUI(buttons)
                } else {
                    startActivity(Intent(this, LessonActivity::class.java))
                    finish()
                }
            }
        }
    }

    private fun loadQuestion() {
        val question = questions[currentQuestionIndex]
        questionText.text = question.question
        option1.text = question.options[0]
        option2.text = question.options[1]
        option3.text = question.options[2]
        option4.text = question.options[3]
        nextButton.text = "Submit Answer"
        nextButton.setBackgroundColor(Color.DKGRAY)
        selectedAnswerIndex = -1
    }

    private fun highlightSelectedAnswer(buttons: List<Button>, selectedIndex: Int) {
        buttons.forEach { it.setBackgroundColor(Color.LTGRAY) }
        buttons[selectedIndex].setBackgroundColor(Color.BLUE)
    }

    private fun resetUI(buttons: List<Button>) {
        buttons.forEach { it.setBackgroundColor(Color.LTGRAY) }
        nextButton.text = "Submit Answer"
        nextButton.setBackgroundColor(Color.DKGRAY)
        selectedAnswerIndex = -1
    }
}

data class QuizQuestion(val question: String, val options: List<String>, val correctAnswer: Int)