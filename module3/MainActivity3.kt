package com.example.module3assgnment

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity3 : AppCompatActivity() {

    lateinit var ed1:EditText
    lateinit var bt1:Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        ed1=findViewById(R.id.ed1)
        bt1=findViewById(R.id.b1)


        bt1.setOnClickListener {
            var tt1= ed1.text.toString()
            var i=Intent(applicationContext,MainActivity4::class.java)
            i.putExtra("passkey",tt1)
            startActivity(i)
        }
    }
}