package com.example.newlayouts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.widget.Button

class MainActivity3 : AppCompatActivity() {
    lateinit var btn1:Button
    lateinit var btn2:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taskactivity)

        btn1=findViewById(R.id.btn1)
        btn2=findViewById(R.id.btn2)

        btn1.setOnClickListener {
            var i= Intent(applicationContext,MainActivity::class.java)
            startActivity(i)
        }
        btn2.setOnClickListener {
            var i= Intent(applicationContext,MainActivity::class.java)
            startActivity(i)
        }

    }
}