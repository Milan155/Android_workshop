package com.example.move_image

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.view.animation.TranslateAnimation
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var blinkImageView: ImageView
    private var isImageVisible = true
    private val blinkIntervalMillis = 500

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        blinkImageView = findViewById(R.id.imageView)
        startBlinking()

    }
    private val blinkRunnable = object : Runnable {
        override fun run() {
            isImageVisible = !isImageVisible
            blinkImageView.visibility = if (isImageVisible) View.VISIBLE else View.INVISIBLE
            handler.postDelayed(this, blinkIntervalMillis.toLong())
        }
    }
    private val handler = Handler()
    override fun onDestroy() {
        super.onDestroy()
        stopBlinking()
    }

    private fun stopBlinking() {
        handler.removeCallbacks(blinkRunnable)
    }

    private fun startBlinking() {
        handler.post(blinkRunnable)
    }


}