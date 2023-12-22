package com.example.musicplayerwithserver

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.musicplayerwithserver.databinding.ActivitySongplayBinding
import com.squareup.picasso.Picasso

class Songplay : AppCompatActivity(), MediaPlayer.OnPreparedListener {


    var mediaPlayer: MediaPlayer = MediaPlayer()
    private lateinit var binding: ActivitySongplayBinding
    var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongplayBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var i = intent
        var pos = i.getIntExtra("mypos", 101)
        var song = i.getStringExtra("songname")
        var singer = i.getStringExtra("singernm")
        var img = i.getStringExtra("img")

        binding.txtSongNm.setText(song)
        binding.txtSingerNm.setText(singer)
        Picasso.get().load(img).placeholder(R.drawable.music).into(binding.imgSong)

        if (pos == 0) {
            mediaPlayer.setDataSource("https://unaffecting-firearm.000webhostapp.com/Music%20folder/Music/iphone_13_original.mp3")
        }
        else
        {
            Toast.makeText(applicationContext, "Choose Validd Song", Toast.LENGTH_SHORT).show()
        }
        mediaPlayer.prepareAsync()
        mediaPlayer.setOnPreparedListener(this)

        Toast.makeText(applicationContext, "Start   " + pos, Toast.LENGTH_SHORT).show()
        binding.btnPlay.setOnClickListener {

            if (mediaPlayer != null && mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                binding.btnPlay.setImageResource(R.drawable.baseline_play_arrow_24)
            } else {
                mediaPlayer.start()
                binding.btnPlay.setImageResource(R.drawable.music1)
            }
        }

        binding.btnNext.setOnClickListener {
            Toast.makeText(applicationContext, "Next", Toast.LENGTH_SHORT).show()
        }
        binding.btnPrevious.setOnClickListener {

            Toast.makeText(applicationContext, "Previous", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onPrepared(mp: MediaPlayer?) {
        mediaPlayer.start()


    }

}