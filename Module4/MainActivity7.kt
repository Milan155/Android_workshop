package com.example.module4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.module4.databinding.ActivityMain7Binding


class MainActivity7 : AppCompatActivity() {

    private lateinit var binding: ActivityMain7Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain7Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.pdf1.setOnClickListener {

            var url="https://topsint.com/careercenter/assignment/android_assignment.pdf"

            var i=Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)
        }






    }
}