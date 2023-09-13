package com.example.module3assgnment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class life_activity_cycle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)

        Toast.makeText(applicationContext, "oncreatecall", Toast.LENGTH_SHORT).show()

        Toast.makeText(applicationContext, "on resume", Toast.LENGTH_SHORT).show()
        Toast.makeText(applicationContext, "on pause", Toast.LENGTH_SHORT).show()
        Toast.makeText(applicationContext, "on stop", Toast.LENGTH_SHORT).show()
        Toast.makeText(applicationContext, "on destroy", Toast.LENGTH_SHORT).show()

    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(applicationContext, "on start", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(applicationContext, "on resume", Toast.LENGTH_SHORT).show()

    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(applicationContext, "on pause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(applicationContext, "on stop", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext, "on destroy", Toast.LENGTH_SHORT).show()
    }
}