package com.example.amulapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    lateinit var A1:ImageView
    lateinit var A2:TextView


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.amul_logo_activity_main)

Handler().postDelayed(Runnable {

                               var i = Intent(applicationContext,LoginPage::class.java)
    startActivity(i)
},3000)
    }
}