package com.example.roadmap

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class cardlayoutscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.cardlayoutscreen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ai)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val androidcard =findViewById<CardView>(R.id.card1)
        val webdevcard = findViewById<CardView>(R.id.card2)
        val aicard =findViewById<CardView>(R.id.card3)
        val mlcard = findViewById<CardView>(R.id.card4)
        val cybercard =findViewById<CardView>(R.id.card5)
        val analyticcard = findViewById<CardView>(R.id.card6)
        val callus = findViewById<Button>(R.id.btncallus)

        androidcard.setOnClickListener {
            val intent=Intent(applicationContext,android_development::class.java)
            startActivity(intent)
        }

        webdevcard.setOnClickListener {
            val intent=Intent(applicationContext,Webdev::class.java)
            startActivity(intent)
        }

        aicard.setOnClickListener {
            val intent=Intent(applicationContext,Ai::class.java)
            startActivity(intent)
        }

        mlcard.setOnClickListener {
            val intent=Intent(applicationContext,Ml::class.java)
            startActivity(intent)
        }
        cybercard.setOnClickListener {
            val intent=Intent(applicationContext,Cybersecurity::class.java)
            startActivity(intent)
        }
        analyticcard.setOnClickListener {
            val intent=Intent(applicationContext,Data_analytics::class.java)
            startActivity(intent)
        }


        callus.setOnClickListener {
//            implicit intent to call from other app
           val intent = Intent(Intent.ACTION_DIAL)
            intent.setData("tel:198".toUri())
            startActivity(intent)
        }

    }
}