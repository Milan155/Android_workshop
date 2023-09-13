package com.example.module4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.module4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
     private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.e1.setOnClickListener {
            var msg = binding.e1.text.toString()
            binding.t1.text.toString()
            binding.t1.setText(msg.reversed())
        }
        binding.e2.setOnClickListener {
            binding.e2.text.toString()

        }
        binding.e3.setOnClickListener {
            binding.e3.text.toString()
        }
        binding.btn1.setOnClickListener {
            var num1 = Integer.parseInt(binding.e2.text.toString())
            var num2 = Integer.parseInt(binding.e3.text.toString())

            var loop:StringBuffer = StringBuffer()

            for (j in num1..num2) {


                loop.append("\n $j")


            }

            var i=Intent(applicationContext,MainActivity2::class.java)
            i.putExtra("num",loop.toString())
            startActivity(i)

        }
    }
}