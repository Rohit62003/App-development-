package com.example.signinandsignup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Sign_up : AppCompatActivity() {
    private lateinit var database : DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnsign_up = findViewById<Button>(R.id.btnsignup)
        val etname = findViewById<TextInputEditText>(R.id.name)
        val etemail = findViewById<TextInputEditText>(R.id.emailid)
        val etusername = findViewById<TextInputEditText>(R.id.username)
        val etpassword =findViewById<TextInputEditText>(R.id.psword)
        val login_now = findViewById<TextView>(R.id.tvloginnow)

        login_now.setOnClickListener{
            val signin_intent = Intent(this,Sign_in::class.java)
            startActivity(signin_intent)
            finish()
        }

        btnsign_up.setOnClickListener{
            val name = etname.text.toString()
            val email= etemail.text.toString()
            val uniqueid = etusername.text.toString()
            val password= etpassword.text.toString()

            val user =data(name , email ,password, uniqueid )
            database = FirebaseDatabase.getInstance().getReference("users")

            database.child(uniqueid).setValue(user).addOnSuccessListener {
                etname.text?.clear()
                Toast.makeText(this,"Registered",Toast.LENGTH_SHORT).show()
                etemail.text?.clear()
                etusername.text?.clear()
                etpassword.text?.clear()

            }.addOnFailureListener {
                Toast.makeText(this,"failed",Toast.LENGTH_SHORT).show()
            }

        }

    }
}