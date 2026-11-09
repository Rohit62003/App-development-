package com.example.toastapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
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
        val downloadbtn = findViewById<Button>(R.id.buttondownload)
        val uploadbtn =  findViewById<Button>(R.id.buttonupload)

        downloadbtn.setOnClickListener {
            Toast.makeText(applicationContext, "downloading...", Toast.LENGTH_SHORT).show()
        }
        uploadbtn.setOnClickListener{
            Toast.makeText(applicationContext, "uploading...", Toast.LENGTH_SHORT).show()
        }
    }
}