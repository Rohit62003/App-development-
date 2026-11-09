package com.example.customizedlistview

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var userArraylist: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val name = arrayOf("Rohit","Ankit","Shankar","Omprakash","Srikant")
        val lstmsg =arrayOf("All is well","part of 3 idiot ","name of good ","hey gorilla ","breakfast dinner lunch")

        val lstmsgtime =arrayOf("4:04 PM","5:04 PM","6:04 PM","4:30 PM","6:14 PM")

        val mobileno = arrayOf("566104864","864346468","652018946","6569780216","7458963211")
        val imgid = intArrayOf(R.drawable.rohit,
            R.drawable.ankit, R.drawable.shankar,R.drawable.omprakash, R.drawable.srikant
        )

        userArraylist = ArrayList()

        for (eachindex in name.indices){
            val user = User(name[eachindex],lstmsg[eachindex],lstmsgtime[eachindex],mobileno[eachindex],imgid[eachindex])

            userArraylist.add(user)
        }

        val listview =findViewById<ListView>(R.id.listview)
        listview.isClickable =true

        listview.adapter = Myadapter(this,userArraylist)

        listview.setOnItemClickListener { parent, view, position, id ->

            val username = name[position]
            val mobilenumber =mobileno[position]
            val picid =imgid[position]

            val i = Intent(this, UserActivity::class.java)
            i.putExtra("name",username)
            i.putExtra("phoneno",mobilenumber)
            i.putExtra("imageid",picid)

            startActivity(i)
            finish()


        }

    }
}