package com.example.customizedlistview

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import de.hdodenhof.circleimageview.CircleImageView

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name =intent.getStringExtra("name")
        val mob = intent.getStringExtra("phoneno")
        val imagid =intent.getIntExtra("imageid",R.drawable.ic_launcher_foreground)

        val tvname = findViewById<TextView>(R.id.tvname)
        val tvmobile= findViewById<TextView>(R.id.tvphone)
        val imgi = findViewById<CircleImageView>(R.id.profile_imag)

        tvname.text=name
        tvmobile.text =mob
        imgi.setImageResource(imagid)

    }
}