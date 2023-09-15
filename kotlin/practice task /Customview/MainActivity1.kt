package com.example.customview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity1 : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list: MutableList<Model>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)


        listView = findViewById(R.id.list1)
        list = ArrayList()


        list.add(Model(R.drawable.pizza, "pizza1", "150","fdgfghfhfbfd"))
        list.add(Model(R.drawable.burger, "burger1", "150","fdgfghfhfbfd"))
        list.add(Model(R.drawable.fafda, "pizza1", "150","fdgfghfhfbfd"))


        var myAdapter = MyAdapter(applicationContext, list)
        listView.adapter = myAdapter

        listView.setOnItemClickListener { parent, view, position, id ->

            var i = Intent(applicationContext, MainActivity2::class.java)
            i.putExtra("pos", position)
            i.putExtra("name", list.get(position).name)
            i.putExtra("num", list.get(position).number)
            i.putExtra("image", list.get(position).image)
            i.putExtra("method",list.get(position).method)
            startActivity(i)


        }
    }



}