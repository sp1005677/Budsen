package com.budzen

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BudgetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_budget) // Ensure this matches the correct XML file

        val incomeInput = findViewById<EditText>(R.id.etIncome)
        val expensesInput = findViewById<EditText>(R.id.etExpenses)
        val savingsText = findViewById<TextView>(R.id.tvSavings)
        val calculateButton = findViewById<Button>(R.id.btnCalculate)

        calculateButton.setOnClickListener {
            val income = incomeInput.text.toString().toDoubleOrNull() ?: 0.0
            val expenses = expensesInput.text.toString().toDoubleOrNull() ?: 0.0
            val savings = income - expenses

            savingsText.text = "Savings: $%.2f".format(savings)
        }
    }
}