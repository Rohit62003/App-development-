package com.example.signinandsignup

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imgbtn = findViewById<ImageView>(R.id.imageView)
        val txt = findViewById<TextView>(R.id.txthello)

        txt.setOnClickListener {
            val intent =Intent(this,Sign_in::class.java)
            startActivity(intent)
        }

        imgbtn.setOnClickListener {
            val inten = Intent(applicationContext, Sign_up::class.java)
            startActivity(inten)
        }

    }
}