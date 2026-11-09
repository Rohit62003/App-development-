package com.example.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class Myadapter(var newsarrayList: ArrayList<News>) :
    RecyclerView.Adapter<Myadapter.MyViewHolder>() {

        lateinit var mylister:OnItemClickListener

    interface OnItemClickListener {
        fun OnItemClicking(position: Int)
    }

    fun SetOnItemClickListner(listener: OnItemClickListener){
        mylister =listener
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.eachnewscard,parent,false)

        return MyViewHolder(itemView,mylister)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = newsarrayList[position]

        holder.hdtittle.text = currentItem.newsTittle
        holder.HImg.setImageResource(currentItem.newsimage)

    }
// this method gives the how many listitems present in array 
    override fun getItemCount(): Int {
        return newsarrayList.size
    }

    class MyViewHolder(itemView: View,listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){
        val hdtittle =itemView.findViewById<TextView>(R.id.tvheadline)
        val HImg = itemView.findViewById<ShapeableImageView>(R.id.headingimg)


        init {
            itemView.setOnClickListener {
                listener.OnItemClicking(adapterPosition)
            }
        }
    }
}