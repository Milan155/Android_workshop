package com.example.module4part_2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView

class plusfont : AppCompatActivity() {

    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var text1: TextView
    var ourFontSize = 14f


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_plusfont)
        button1 = findViewById(R.id.plusbutton)
        button2 = findViewById(R.id.minusbutton)
        text1 = findViewById(R.id.Textid)

        button1.setOnClickListener {
            ourFontSize += 14f
            text1.setTextSize(TypedValue.COMPLEX_UNIT_SP, ourFontSize)
        }


            button2.setOnClickListener {
                ourFontSize -= 14f
                text1.setTextSize(TypedValue.COMPLEX_UNIT_SP, ourFontSize)
            }


            }
        }


