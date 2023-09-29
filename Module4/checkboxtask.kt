package com.example.module4part_2

import android.annotation.SuppressLint
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible

class checkboxtask : AppCompatActivity() {
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var text1: TextView


    @SuppressLint("MissingInflatedId", "NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkboxtask)


        button1 = findViewById(R.id.showbutton)
        button2 = findViewById(R.id.hidebutton)
        text1 = findViewById(R.id.text1)

        button1.setOnClickListener {
            text1.visibility=View.VISIBLE
        }
        button2.setOnClickListener {
            text1.visibility = View.INVISIBLE
        }


    }
}

