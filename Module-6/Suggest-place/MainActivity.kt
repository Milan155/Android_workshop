package com.example.suggest_place

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView

class MainActivity : AppCompatActivity() {

    lateinit var auto:AutoCompleteTextView
    var city = arrayOf("Rajkot","surat","baroda","Ahmadabad","vadodara","Gandhinagar","nagpur")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auto=findViewById(R.id.auto1)


        var adapter=ArrayAdapter(this,android.R.layout.select_dialog_item,city)
        auto.threshold=1
        auto.setAdapter(adapter)
    }
}