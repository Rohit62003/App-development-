package com.example.evenoddchecker

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
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val btn = findViewById<Button>(R.id.button)
        val inputNumber = findViewById<EditText>(R.id.editTextNumberSigned)
        val outputresult = findViewById<TextView>(R.id.textView)

        btn.setOnClickListener {
            val number = inputNumber.text.toString().toInt()

            if (number % 2 == 0) {
                outputresult.text = "Even"

            } else {
                outputresult.text = "odd"
            }
        }
    }
}
