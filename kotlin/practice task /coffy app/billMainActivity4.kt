package com.example.coffy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class billMainActivity4 : AppCompatActivity() {

       lateinit var t1:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bill_main4)


        var i = intent
        t1 = findViewById(R.id.z1)
        t1.setText(i.getStringExtra("bill"))

    }
}