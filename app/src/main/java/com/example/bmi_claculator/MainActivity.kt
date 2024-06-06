package com.example.bmi_claculator

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var heightEditText: EditText
    private lateinit var weightEditText: EditText
    private lateinit var resultTextView: TextView
    private lateinit var calculateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        heightEditText = findViewById(R.id.heightEditText)
        weightEditText = findViewById(R.id.weightEditText)
        resultTextView = findViewById(R.id.resultTextView)
        calculateButton = findViewById(R.id.calculateButton)

        // Set onClick listener for the button
        calculateButton.setOnClickListener {
            calculateBMI()
        }
    }

    private fun calculateBMI() {
        val heightStr = heightEditText.text.toString()
        val weightStr = weightEditText.text.toString()

        if (!TextUtils.isEmpty(heightStr) && !TextUtils.isEmpty(weightStr)) {
            val height = heightStr.toFloat()
            val weight = weightStr.toFloat()

            val bmi = weight / (height * height)

            displayBMI(bmi)
        } else {
            resultTextView.text = "Please enter valid values"
        }
    }

    private fun displayBMI(bmi: Float) {
        val bmiLabel: String = when {
            bmi < 18.5 -> "Underweight"
            (bmi >18.5) && (bmi < 24.9) -> "Normal"
            (bmi > 25.0) && (bmi < 29.9) -> "Overweight"
            (bmi > 30.0) && (bmi < 34.9) -> "Obesity class I"
            (bmi > 35.0) && (bmi < 24.9) -> "Obesity class II"
            bmi < 30 -> "Overweight"
            else -> "Obese"
        }

        resultTextView.text = String.format("BMI: %.2f (%s)", bmi, bmiLabel)
    }
}
