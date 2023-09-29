package com.example.module4part_2

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var l1:LinearLayout



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1=findViewById(R.id.rd1)
        button2=findViewById(R.id.rd2)
        button3=findViewById(R.id.rd3)
        l1=findViewById(R.id.l1)


        button1.setOnClickListener {
            l1.setBackgroundColor(Color.RED)
        }

        button2.setOnClickListener {
            l1.setBackgroundColor(Color.YELLOW)
        }

        button3.setOnClickListener {
            l1.setBackgroundColor(Color.DKGRAY)
        }
    }
}