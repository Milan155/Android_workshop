package com.example.image_rotateblink

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    lateinit var imageView: ImageView

    lateinit var imageView2: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView=findViewById(R.id.imageView)

        imageView2=findViewById(R.id.imageView2)


        rotateImage(imageView, 45.0f)
        blinkImage(imageView, 1000)

    }

    private fun rotateImage(imageView: ImageView, degrees: Float) {
        val rotateAnimation = RotateAnimation(0.0f, degrees,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f)
        rotateAnimation.duration = 1000 // 1 second
        rotateAnimation.fillAfter = true
        imageView.startAnimation(rotateAnimation)
    }


    private fun blinkImage(imageView: ImageView, duration: Long) {
        val alphaAnimation = AlphaAnimation(1.0f, 0.0f)
        alphaAnimation.duration = duration
        alphaAnimation.repeatCount = Animation.INFINITE
        alphaAnimation.repeatMode = Animation.REVERSE
        imageView.startAnimation(alphaAnimation)
    }
}