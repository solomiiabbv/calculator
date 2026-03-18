package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // TextView для відображення результату
    private lateinit var tvResult: TextView

    // Змінна для збереження введеного виразу
    private var currentInput = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Підключення TextView
        tvResult = findViewById(R.id.tvResult)
        // Обробка кнопки 1
        findViewById<Button>(R.id.btn1).setOnClickListener {
            currentInput += "1"
            tvResult.text = currentInput
        }
        // Кнопки 2 і 3
        findViewById<Button>(R.id.btn2).setOnClickListener {
            currentInput += "2"
            tvResult.text = currentInput
        }

        findViewById<Button>(R.id.btn3).setOnClickListener {
            currentInput += "3"
            tvResult.text = currentInput
        }

// Кнопка +
        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            currentInput += "+"
            tvResult.text = currentInput
        }
        // Кнопка Clear
        findViewById<Button>(R.id.btnClear).setOnClickListener {
            currentInput = ""
            tvResult.text = "0"
        }
    }

}