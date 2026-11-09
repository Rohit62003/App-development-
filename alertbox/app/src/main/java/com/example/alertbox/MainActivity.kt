package com.example.alertbox

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alertbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
binding.btn1.setOnClickListener {

    val builder1 = AlertDialog.Builder(this)
    builder1.setTitle("Alert dear")
    builder1.setMessage("Do to want to Exit ")
    builder1.setIcon(R.drawable.baseline_exit_to_app_24)

    builder1.setPositiveButton("Yes", DialogInterface.OnClickListener{ DialogInterface,i ->
//       close app
        finish()
    })
    builder1.setNegativeButton("No", DialogInterface.OnClickListener{ DialogInterface,i ->
//        not close app
    })

    builder1.show()
        }



        binding.btn2.setOnClickListener {
            val arraylist =arrayOf("Mon","Tues","Wed","Thru","Fri","Sat","Sun")
            val builder2 = AlertDialog.Builder(this)

            builder2.setTitle("Which day you will take Rest ?")
            builder2.setSingleChoiceItems(arraylist,6, DialogInterface.OnClickListener{ Dialog,which ->
                Toast.makeText(this, "you take leave on ${arraylist[which]}", Toast.LENGTH_SHORT).show()
            })

            builder2.setPositiveButton("Submit" , DialogInterface.OnClickListener{ DialogInterface,i ->
//               what action taken on submit
            })


            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener{ DialogInterface,i ->
//                 what action taken on submit
            })
            builder2.show()
        }


     binding.btn3.setOnClickListener {
         val builder3 = AlertDialog.Builder(this)
         val arraylist =arrayOf("Mon","Tues","Wed","Thru","Fri","Sat","Sun")
         builder3.setTitle("Which day you will take Rest ?")
         builder3.setMultiChoiceItems(arraylist,null, DialogInterface.OnMultiChoiceClickListener{ Dialog,which,ischecked ->
             Toast.makeText(this, "You selected the ${arraylist[which]}", Toast.LENGTH_SHORT).show()
         })

         builder3.setPositiveButton("Done", DialogInterface.OnClickListener{ DialogInterface,i ->
//             what happen on click
         })


         builder3.setNegativeButton("no", DialogInterface.OnClickListener{ DialogInterface,i ->
//                  what action taken 
         })

         builder3.show()
     }

    }
}