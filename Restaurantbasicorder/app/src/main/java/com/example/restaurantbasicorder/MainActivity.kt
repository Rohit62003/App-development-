package com.example.restaurantbasicorder

import android.content.Intent
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    companion object{
        const val KEY = "com.example.restaurantbasicorder.MainActivity.KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val order1 = findViewById<EditText>(R.id.order1)
        val order2 = findViewById<EditText>(R.id.order2)
        val order3 = findViewById<EditText>(R.id.order3)
        val order4 = findViewById<EditText>(R.id.order4)
        val btorder = findViewById<Button>(R.id.btnorder)

            btorder.setOnClickListener {
            val order = order1.text.toString() +" " + order2.text.toString()+ " " +order3.text.toString()+
                    " " +order4.text.toString()

            val intent = Intent(this,showorder::class.java)
                intent.putExtra(KEY,order)
                startActivity(intent)
            }

    }

}