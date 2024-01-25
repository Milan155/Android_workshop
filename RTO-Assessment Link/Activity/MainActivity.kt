package com.example.rto_assessment.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rto_assessment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.quetionid.setOnClickListener {
            var i= Intent(applicationContext,Intro_page::class.java)
            startActivity(i)
        }

        binding.rules.setOnClickListener {
            var i= Intent(applicationContext,Rules_and_videos::class.java)
            startActivity(i)
        }

        binding.Registration.setOnClickListener {
            var i= Intent(applicationContext,Rto_registration::class.java)
            startActivity(i)
        }

        binding.aboutus.setOnClickListener {
            var i= Intent(applicationContext,About_thisapp::class.java)
            startActivity(i)
        }


    }
}