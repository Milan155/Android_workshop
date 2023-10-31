package com.example.module_5firstassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.module_5firstassignment.databinding.ActivityUpdatedataBinding

class Updatedata : AppCompatActivity() {

    private lateinit var binding: ActivityUpdatedataBinding
    lateinit var dbhelper: Dbhelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdatedataBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        dbhelper= Dbhelper(applicationContext)

        var i= intent
        var id=i.getIntExtra("id",101)
        var title=i.getStringExtra("title")
        var task=i.getStringExtra("task")

        binding.edt1.setText(title)
        binding.edt2.setText(task)
        dbhelper= Dbhelper(applicationContext)

        binding.btn1.setOnClickListener {
            var title=binding.edt1.text.toString()
            var task=binding.edt2.text.toString()

            var m=Model()
            m.id=id
            m.title=title
            m.task=task

            dbhelper.update(m)

            Toast.makeText(applicationContext,"updated your data",Toast.LENGTH_SHORT).show()
            startActivity(Intent(applicationContext,MainActivity::class.java))
        }
    }
}