package com.example.recycleview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewsContents : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_news_contents)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val heading = intent.getStringExtra("heading")
        val imagesId = intent.getIntExtra("imgid",R.drawable.img3)
        val Content = intent.getStringExtra("Contents")


        val Newstittle = findViewById<TextView>(R.id.tVTittle)
        val NewsDescription = findViewById<TextView>(R.id.tvDescription)
       val tvImgs = findViewById<ImageView>(R.id.newsImages)
        Newstittle.text = heading
        NewsDescription.text =Content
        tvImgs.setImageResource(imagesId)
    }
}