package com.example.module4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import android.widget.TextView
import com.example.module4.databinding.ActivityMain6Binding

class MainActivity6 : AppCompatActivity() {

    private lateinit var binding: ActivityMain6Binding
    lateinit var tble:TableLayout
    lateinit var txt :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain6Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        tble= TableLayout(this)
        txt= TextView(this)


        txt.setText("MMM")

        var height = 250
        var width = 250

        tble.addView(txt,height,width)
        setContentView(tble)



    }
}