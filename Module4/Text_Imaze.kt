package com.example.module4part_2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Text_Imaze : AppCompatActivity() {
    lateinit var txt1:TextView



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_imaze)

        txt1=findViewById(R.id.imaze1)

        txt1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.imz1,R.drawable.imz2,R.drawable.imz3,R.drawable.ic_launcher_background)



    }
}



