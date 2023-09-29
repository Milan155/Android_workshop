package com.example.module4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity8 : AppCompatActivity() {

      lateinit var edit1:EditText
      lateinit var btn1:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)


        val edit1=findViewById<EditText>(R.id.Edit1)
        val btn1=findViewById<Button>(R.id.btn1)


        btn1.setOnClickListener {
            val text=edit1.text
            Toast.makeText(this,text,Toast.LENGTH_SHORT).show()


        }

        }
    }
