package com.example.splashscreens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private val splashDuration = 4000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val splashLogoImageView: ImageView = findViewById(R.id.splashLogoImageView)

        val animation = AnimationUtils.loadAnimation(this, R.anim.animy)
        splashLogoImageView.startAnimation(animation)

        Handler().postDelayed({
            val intent= Intent(this,MainActivity2::class.java)
            startActivity(intent)
            finish()
        },splashDuration)


    }
}