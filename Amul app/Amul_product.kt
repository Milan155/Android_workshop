package com.example.amulapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.QUEUE_ADD
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.Locale

class Amul_product : AppCompatActivity(), TextToSpeech.OnInitListener {

    lateinit var mithaimq: ImageView
    lateinit var cheeseimg: ImageView

    lateinit var text_mitha: TextView
    lateinit var text_cheese: TextView
    lateinit var tts: TextToSpeech


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amul_product)

        mithaimq = findViewById(R.id.image1)
        cheeseimg = findViewById(R.id.image3)

        text_mitha = findViewById(R.id.imaze2)
        text_cheese = findViewById(R.id.image4)

        tts = TextToSpeech(applicationContext, this)


        mithaimq.setOnClickListener {

            var txt1 = text_mitha.toString()
            tts.speak(txt1, QUEUE_ADD, null)

        }
        text_mitha.setOnClickListener {
            Toast.makeText(applicationContext, "32rs", Toast.LENGTH_SHORT).show()
        }


         cheeseimg.setOnClickListener {

            //implicit
            var cheesegurl = "https://amul.com/products/amul-gold-info.php"
            var i1 = Intent(Intent.ACTION_VIEW)
            i1.setData(Uri.parse(cheesegurl))
            startActivity(i1)

        }
        text_cheese.setOnClickListener {
            Toast.makeText(applicationContext, "32rs", Toast.LENGTH_SHORT).show()
   }
        }

         override fun onInit(status: Int)
        {
            tts.setLanguage(Locale.US)
            tts.setPitch(0.8f)
            tts.setSpeechRate(1f)
        }

}








