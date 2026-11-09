package com.example.signinandsignup

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WelcomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val  name = intent.getStringExtra(Sign_in.Key1)
        val mail =intent.getStringExtra(Sign_in.Key2)
        val userid=intent.getStringExtra(Sign_in.Key3)


        val wlcname =findViewById<TextView>(R.id.tvname)
        val emailtv =findViewById<TextView>(R.id.tvemail)
        val usernametv = findViewById<TextView>(R.id.tvseridname)

        usernametv.text = "Welcome $userid"
        wlcname.text = "Name : $name"
        emailtv.text="Mail : $mail"





    }
}