package com.example.amulapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class activity_amul_dropped : AppCompatActivity()

{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amul_dropped)

        Handler().postDelayed(Runnable {
            var i=Intent(applicationContext,MainActivity::class.java)
            startActivity(i)


        },3000)
    }

    }
