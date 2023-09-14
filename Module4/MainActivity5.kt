package com.example.module4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isInvisible
import com.example.module4.databinding.ActivityMain5Binding
import com.example.module4.databinding.ActivityMainBinding

class MainActivity5 : AppCompatActivity() {
    private lateinit var binding: ActivityMain5Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain5Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        binding.showbtn.setOnClickListener {
            binding.txtname.visibility=View.VISIBLE
        }
        binding.hidebtn.setOnClickListener {
            binding.txtname.visibility=View.INVISIBLE
        }


    }





}