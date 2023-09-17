package com.example.grid3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
     lateinit var img2:ImageView
    lateinit var text1:TextView
    lateinit var text2:TextView
    lateinit var text3:TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        img2 = findViewById(R.id.img2)
        text1 = findViewById(R.id.text1)
        text2 = findViewById(R.id.text2)
        text3=findViewById(R.id.text3)


        var i=intent

        img2.setImageResource(i.getIntExtra("image",0))
        text1.setText(i.getStringExtra("name"))
        text2.setText(i.getStringExtra("method"))
        text3.setText(i.getStringExtra("num"))




    }
}