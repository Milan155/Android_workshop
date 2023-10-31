package com.example.module_5firstassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.module_5firstassignment.databinding.ActivityAdddataBinding

class Adddata : AppCompatActivity() {

    private lateinit var binding: ActivityAdddataBinding
    lateinit var dbhelper: Dbhelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdddataBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dbhelper = Dbhelper(applicationContext)

        binding.btn1.setOnClickListener {
            var title=binding.edt1.text.toString()
            var task=binding.edt2.text.toString()

            var m=Model()
            m.title=title
            m.task=task

            dbhelper.insert(m)

            Toast.makeText(applicationContext,"Inserted your data",Toast.LENGTH_SHORT).show()
            startActivity(Intent(applicationContext,MainActivity::class.java    ))

        }
    }
}