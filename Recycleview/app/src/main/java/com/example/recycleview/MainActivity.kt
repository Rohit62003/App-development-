package com.example.recycleview

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var myrecyclerView: RecyclerView
    lateinit var newarraylist : ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        myrecyclerView = findViewById(R.id.Recyclerview)

        val newsImageList = arrayOf(R.drawable.img1,
                            R.drawable.img2,
                            R.drawable.img3,
                            R.drawable.img4,
                            R.drawable.img5,
                            R.drawable.img6,
                            R.drawable.img7
                )

        val newsHeadLines = arrayOf("ET AI Awards 2025: The Stage Startups Can’t Afford to Miss",
            "Google Finance Unleashes AI: The Dawn of Smart Money Tracking",
            "Credibility Is the New Currency: Why Winning AI Recognition Is the Ultimate Growth Hack for Startups",
            "Improving Telecommunications with Edge AI",
            "As AI becomes part of everyday life, it brings a hidden climate cost",
            "Fun Fact About AI: How Its Roots Go Back to 1955-56",
            "Google’s Gemini cracks problem no human could solve at global coding contest"
            )

        val NewsContent = arrayOf(
            getString(R.string.NewsCOntent3),
            getString(R.string.NewsCOntent3),
            getString(R.string.NewsCOntent3),
            getString(R.string.NewsCOntent3),
            getString(R.string.NewsCOntent3),
            getString(R.string.NewsCOntent3),
            getString(R.string.NewsCOntent3)
            )


//

        myrecyclerView.layoutManager = LinearLayoutManager(this)
        newarraylist=arrayListOf<News>()

        for (index in newsImageList.indices){

            val news =News(newsHeadLines[index],newsImageList[index], NewsContent[index] )
            newarraylist.add(news)
        }

        val myAdapter = Myadapter(newarraylist )
        myrecyclerView.adapter = myAdapter

        myAdapter.SetOnItemClickListner(object : Myadapter.OnItemClickListener {
            override fun OnItemClicking(position: Int) {
              val intent = Intent(this@MainActivity, NewsContents::class.java)

                intent.putExtra("heading",newarraylist[position].newsTittle)
                intent.putExtra("imgid",newarraylist[position].newsimage)
                intent.putExtra("Contents",newarraylist[position].newsContent)
                startActivity(intent)
                finish()
            }
        })
    }
}

