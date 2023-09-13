package com.example.module4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.module4.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity()
{
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        var i = intent
        var data=i.getStringExtra("num")
        binding.txtresult.setText(data)


        binding.radiobutton.setOnClickListener {
            var i=Intent(applicationContext,MainActivity3::class.java)
            startActivity(i)

        }
    }

}