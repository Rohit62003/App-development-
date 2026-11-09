package com.example.factorialsfinder

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val numInput = findViewById<EditText>(R.id.enternum)
        val btn = findViewById<Button>(R.id.button)
        val resultView = findViewById<TextView>(R.id.textViewresult)

        fun factorial(n: Int): Int {
            return if (n == 0 || n == 1) 1 else n * factorial(n - 1)
        }

        btn.setOnClickListener {
            val inputText = numInput.text.toString()
            val number = inputText.toIntOrNull()

            if (number == null || number < 0) {
                resultView.text = "Please enter a valid non-negative number"
            } else {
                val result = factorial(number)
                resultView.text = "Factorial of $number is $result"
            }
        }
    }
}