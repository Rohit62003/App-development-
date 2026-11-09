package com.example.customizedlistview

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView
import java.util.zip.Inflater

class Myadapter(val context: Activity ,val arrayList: ArrayList<User>) :
    ArrayAdapter<User>(context,R.layout.customizedlayout,arrayList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflator = LayoutInflater.from(context)
        val  view =inflator.inflate(R.layout.customizedlayout,null)

        val image =view.findViewById<CircleImageView>(R.id.profile_image)
        val name =view.findViewById<TextView>(R.id.txtname)
        val lastmseg =view.findViewById<TextView>(R.id.txtlstmsg)
        val lasttime =view.findViewById<TextView>(R.id.txtlstmsgtime)

        name.text = arrayList[position].name
        lastmseg.text =arrayList[position].lastmsg
        lasttime.text = arrayList[position].lastmsgtime
        image.setImageResource(arrayList[position].imageId)


        return view
    }
}