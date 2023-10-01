package com.example.login

import android.media.MediaPlayer
import android.media.MediaPlayer.OnPreparedListener
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    lateinit var videoView: VideoView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        videoView = findViewById(R.id.video1)

        var uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.video2)
        videoView.setVideoURI(uri)


        videoView.setOnPreparedListener(object : OnPreparedListener {
            override fun onPrepared(p0: MediaPlayer?) {

            }
        })

        videoView.start()
    }
}
