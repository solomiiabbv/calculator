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

        // --------------------
        // Обробка кнопки 1
        findViewById<Button>(R.id.btn1).setOnClickListener {
            currentInput += "1"
            tvResult.text = currentInput
        }

        // Обробка кнопки 2
        findViewById<Button>(R.id.btn2).setOnClickListener {
            currentInput += "2"
            tvResult.text = currentInput
        }

        // Обробка кнопки 3
        findViewById<Button>(R.id.btn3).setOnClickListener {
            currentInput += "3"
            tvResult.text = currentInput
        }

        // Обробка кнопки +
        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            currentInput += "+"
            tvResult.text = currentInput
        }

        // Обробка кнопки Clear
        findViewById<Button>(R.id.btnClear).setOnClickListener {
            currentInput = ""
            tvResult.text = "0"
        }

// Множення *
        findViewById<Button>(R.id.btnMul).setOnClickListener {
            currentInput += "*"
            tvResult.text = currentInput
        }

// Ділення /
        findViewById<Button>(R.id.btnDiv).setOnClickListener {
            currentInput += "/"
            tvResult.text = currentInput
        }

// Віднімання -
        findViewById<Button>(R.id.btnSub).setOnClickListener {
            currentInput += "-"
            tvResult.text = currentInput
        }

// Цифри 4,5,6
        findViewById<Button>(R.id.btn4).setOnClickListener {
            currentInput += "4"
            tvResult.text = currentInput
        }

        findViewById<Button>(R.id.btn5).setOnClickListener {
            currentInput += "5"
            tvResult.text = currentInput
        }

        findViewById<Button>(R.id.btn6).setOnClickListener {
            currentInput += "6"
            tvResult.text = currentInput
        }

// Цифри 7,8,9
        findViewById<Button>(R.id.btn7).setOnClickListener {
            currentInput += "7"
            tvResult.text = currentInput
        }

        findViewById<Button>(R.id.btn8).setOnClickListener {
            currentInput += "8"
            tvResult.text = currentInput
        }

        findViewById<Button>(R.id.btn9).setOnClickListener {
            currentInput += "9"
            tvResult.text = currentInput
        }

// Цифра 0
        findViewById<Button>(R.id.btn0).setOnClickListener {
            currentInput += "0"
            tvResult.text = currentInput
        }
    }


}
