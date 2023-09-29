package com.example.module4part_2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.widget.ContentLoadingProgressBar

class seekbarMainActivity2 : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    lateinit var text1: TextView
    lateinit var text2: TextView
    lateinit var text3: TextView
    lateinit var seekbar1: SeekBar
    lateinit var seekbar2: SeekBar
    lateinit var seekbar3: SeekBar
    lateinit var liner1: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seekbar_main2)


        liner1 = findViewById(R.id.liner1)
        text1 = findViewById(R.id.txt1)
        text2 = findViewById(R.id.txt2)
        text3 = findViewById(R.id.txt3)
        seekbar1 = findViewById(R.id.seek1)
        seekbar2 = findViewById(R.id.seek2)
        seekbar3 = findViewById(R.id.seek3)

        seekbar1.setOnSeekBarChangeListener(this)
        seekbar2.setOnSeekBarChangeListener(this)
        seekbar3.setOnSeekBarChangeListener(this)


    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        var r=seekbar1!!.progress
        var g=seekbar2!!.progress
        var b=seekbar3!!.progress

        liner1.setBackgroundColor(Color.rgb(r,g,b))
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {

    }

    override fun onStopTrackingTouch(p0: SeekBar?) {

    }
}


