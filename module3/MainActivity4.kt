package com.example.module3assgnment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity4 : AppCompatActivity() {


    lateinit var tq:TextView



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
      tq=findViewById(R.id.Tq1)

        var txtR=intent.getStringExtra("passkey")
        tq.setText(txtR)




    }
}