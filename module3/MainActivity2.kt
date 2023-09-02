package com.example.module3assgnment

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import javax.microedition.khronos.egl.EGL10

class MainActivity2 : AppCompatActivity() {



    lateinit var B1:Button
    lateinit var B2:Button
    lateinit var B3:Button
    lateinit var B4:Button
    lateinit var R1:RelativeLayout
    lateinit var l1:Button
    lateinit var Rr1:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        B1= findViewById(R.id.btn1)
        B2= findViewById(R.id.btn2)
        B3= findViewById(R.id.btn3)
        B4= findViewById(R.id.btn4)
        R1= findViewById(R.id.Rele1)
        l1= findViewById(R.id.loginbt1)
        Rr1= findViewById(R.id.loginbt2)



        B1.setOnClickListener {
            R1.setBackgroundColor(Color.RED)
        }

        B2.setOnClickListener {
            R1.setBackgroundColor(Color.YELLOW)
        }
        B3.setOnClickListener {
            R1.setBackgroundColor(Color.WHITE)
        }
        B4.setOnClickListener {
            var i= Intent(applicationContext,MainActivity3::class.java)
            startActivity(i)
        }
        l1.setOnClickListener {
            var i= Intent(applicationContext,MainActivity5::class.java)
            startActivity(i)
        }
        Rr1.setOnClickListener {
            var i= Intent(applicationContext,MainActivity6::class.java)
            startActivity(i)
        }
    }
}