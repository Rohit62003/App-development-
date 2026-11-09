package com.example.listview

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
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
        val listview= findViewById<ListView>(R.id.listview)
        val txtlistview = arrayListOf<String>()

        txtlistview.add("learn from error ")
        txtlistview.add("earn skill")
        txtlistview.add("skill gives money")
        txtlistview.add("money gives life.....")
        txtlistview.add("so start learn ")

        val listAdapterfortxt = ArrayAdapter(this,android.R.layout.simple_list_item_1,txtlistview)

        listview.adapter=listAdapterfortxt

//        method 1 on click on item of listliew


//        listview.setOnItemClickListener { parent, view, position, id ->
//            val txtclick = (view as TextView).text.toString()
//
//            Toast.makeText(this, "click on $txtclick", Toast.LENGTH_SHORT).show()
//
//             }

// method 2 on click on item of listliew
        listview.onItemClickListener = AdapterView.OnItemClickListener{ parent,view, i, lng ->
            val txtclick = (view as TextView).text.toString()

            Toast.makeText(this, "click on $txtclick", Toast.LENGTH_SHORT).show()

        }

        }
}