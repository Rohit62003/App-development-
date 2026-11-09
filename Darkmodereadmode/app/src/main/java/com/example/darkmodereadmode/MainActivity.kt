package com.example.darkmodereadmode

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val layout=findViewById<LinearLayout>(R.id.main)
        val btndarkmode =findViewById<Button>(R.id.btndark)
        val btnreadmode =findViewById<Button>(R.id.btnread)
        btndarkmode.setOnClickListener {
            layout.setBackgroundColor(R.color.black)
        }
        btnreadmode.setOnClickListener {
            layout.setBackgroundColor(R.color.Cream)
        }

    }
}