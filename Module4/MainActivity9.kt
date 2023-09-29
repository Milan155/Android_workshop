package com.example.module4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity9 : AppCompatActivity() {

    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main9)

        val arrayAdapter:ArrayAdapter<*>
        val users= arrayOf(
            "m1","m2","m3"
        )
        var mylist=findViewById<ListView>(R.id.listview)
        arrayAdapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,users)
        mylist.adapter=arrayAdapter



    }

}