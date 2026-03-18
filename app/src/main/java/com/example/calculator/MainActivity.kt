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
        // Кнопки цифр
        findViewById<Button>(R.id.btn0).setOnClickListener { appendToInput("0") }
        findViewById<Button>(R.id.btn1).setOnClickListener { appendToInput("1") }
        findViewById<Button>(R.id.btn2).setOnClickListener { appendToInput("2") }
        findViewById<Button>(R.id.btn3).setOnClickListener { appendToInput("3") }
        findViewById<Button>(R.id.btn4).setOnClickListener { appendToInput("4") }
        findViewById<Button>(R.id.btn5).setOnClickListener { appendToInput("5") }
        findViewById<Button>(R.id.btn6).setOnClickListener { appendToInput("6") }
        findViewById<Button>(R.id.btn7).setOnClickListener { appendToInput("7") }
        findViewById<Button>(R.id.btn8).setOnClickListener { appendToInput("8") }
        findViewById<Button>(R.id.btn9).setOnClickListener { appendToInput("9") }

        // --------------------
        // Операції
        findViewById<Button>(R.id.btnAdd).setOnClickListener { appendToInput("+") }
        findViewById<Button>(R.id.btnSub).setOnClickListener { appendToInput("-") }
        findViewById<Button>(R.id.btnMul).setOnClickListener { appendToInput("*") }
        findViewById<Button>(R.id.btnDiv).setOnClickListener { appendToInput("/") }

        // --------------------
        // Кнопка Clear
        findViewById<Button>(R.id.btnClear).setOnClickListener {
            currentInput = ""
            tvResult.text = "0"
        }

        // --------------------
        // Кнопка =
        findViewById<Button>(R.id.btnEqual).setOnClickListener {
            try {
                val result = eval(currentInput)
                tvResult.text = result.toString()
                currentInput = result.toString()
            } catch (e: Exception) {
                tvResult.text = "Error"
                currentInput = ""
            }
        }
    }

    // Додаємо символ до введення та оновлюємо TextView
    private fun appendToInput(str: String) {
        currentInput += str
        tvResult.text = currentInput
    }

    // Функція для обчислення виразу
    private fun eval(expr: String): Double {
        return object {
            var pos = -1
            var ch = 0
            fun nextChar() { ch = if (++pos < expr.length) expr[pos].toInt() else -1 }
            fun eat(charToEat: Int): Boolean {
                while (ch == ' '.toInt()) nextChar()
                if (ch == charToEat) { nextChar(); return true }
                return false
            }
            fun parse(): Double {
                nextChar()
                val x = parseExpression()
                if (pos < expr.length) throw RuntimeException("Unexpected: " + expr[pos])
                return x
            }
            fun parseExpression(): Double {
                var x = parseTerm()
                while(true) {
                    x = when {
                        eat('+'.toInt()) -> x + parseTerm()
                        eat('-'.toInt()) -> x - parseTerm()
                        else -> return x
                    }
                }
            }
            fun parseTerm(): Double {
                var x = parseFactor()
                while(true) {
                    x = when {
                        eat('*'.toInt()) -> x * parseFactor()
                        eat('/'.toInt()) -> x / parseFactor()
                        else -> return x
                    }
                }
            }
            fun parseFactor(): Double {
                if (eat('+'.toInt())) return parseFactor()
                if (eat('-'.toInt())) return -parseFactor()

                var x: Double
                val startPos = pos
                if ((ch >= '0'.toInt() && ch <= '9'.toInt()) || ch == '.'.toInt()) {
                    while ((ch >= '0'.toInt() && ch <= '9'.toInt()) || ch == '.'.toInt()) nextChar()
                    x = expr.substring(startPos, pos).toDouble()
                } else {
                    throw RuntimeException("Unexpected: " + ch.toChar())
                }
                return x
            }
        }.parse()
    }
}
