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
    }

}