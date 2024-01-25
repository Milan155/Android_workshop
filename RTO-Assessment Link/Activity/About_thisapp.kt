package com.example.rto_assessment.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rto_assessment.Adapters.Grid_aboutus
import com.example.rto_assessment.R

class About_thisapp : AppCompatActivity() {


    lateinit var scrollableLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_thisapp)


        scrollableLayout = findViewById(R.id.scrollableLayout)

        val data: List<String> = arrayListOf("1",)
        val chunkedData = data.chunked(4) // Split the list into chunks of 10

        chunkedData.forEach { chunkList ->
            val recyclerView = RecyclerView(applicationContext)
            recyclerView.layoutManager = GridLayoutManager(this, 1) // 5 columns in grid
            recyclerView.adapter = Grid_aboutus(chunkList)

            scrollableLayout.addView(recyclerView)
        }
    }
}