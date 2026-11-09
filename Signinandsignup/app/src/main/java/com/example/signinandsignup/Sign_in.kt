package com.example.signinandsignup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Sign_in : AppCompatActivity() {

    private lateinit var databaseReference: DatabaseReference
companion object{
    const val Key1 = "com.example.signinandsignup.Sign_in.name"
    const val Key2 = "com.example.signinandsignup.Sign_in.mail"
    const val Key3 = "com.example.signinandsignup.Sign_in.userid"
}



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val username = findViewById<TextInputEditText>(R.id.tvusername)
        val password = findViewById<TextInputEditText>(R.id.editTextTextPassword)
        val btsignin = findViewById<Button>(R.id.btnsigin)

        btsignin.setOnClickListener {

            val user = username.text.toString()
            val userpassword = password.text.toString().trim()

            if(user.isNotEmpty() && userpassword.isNotEmpty()) {
                readdata(user,userpassword)
            } else {
                Toast.makeText(this, "username is empty", Toast.LENGTH_SHORT).show()
            }

        }
    }
    private fun readdata(user: String,uPassword:String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("users")
        databaseReference.child(user).get().addOnSuccessListener {

            if(it.exists()) {
                val email = it.child("email").value
                val name = it.child("name").value
                val username = it.child("userid").value
                val storedpassword =it.child("password").value.toString()


                if (uPassword == storedpassword) {
                    Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
//                intent
                    val intentwl = Intent(this, WelcomeScreen::class.java)

                    intentwl.putExtra(Key1, name.toString())
                    intentwl.putExtra(Key2, email.toString())
                    intentwl.putExtra(Key3, username.toString())
                    startActivity(intentwl)
                    finish()
                }
                else{
                    Toast.makeText(this, "invalid user", Toast.LENGTH_SHORT).show()
                }
            }
        else {
                Toast.makeText(this, "enter the valid id", Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener {
            Toast.makeText(this, "internal db issue", Toast.LENGTH_SHORT).show()
        }


    }
}