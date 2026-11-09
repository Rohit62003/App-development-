package com.example.customizeddialogbox

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var dialog: Dialog
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mybtn = findViewById<Button>(R.id.btn1)
        dialog = Dialog(this)
        dialog.setContentView(R.layout.customdialog)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg))
        val btnfeedback = dialog.findViewById<Button>(R.id.buttonfeedback)
        val btnok = dialog.findViewById<Button>(R.id.buttonok)

        btnok.setOnClickListener {
            dialog.dismiss()
        }

        btnfeedback.setOnClickListener {
//        use intent or webview concept 
            Toast.makeText(this, "thank you ", Toast.LENGTH_SHORT).show()
            dialog.cancel()
            
        }

        mybtn.setOnClickListener {
            dialog.show()
        }
    }
}