package com.example.cameracalls
import android.Manifest.permission.CALL_PHONE
import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.ACTION_IMAGE_CAPTURE
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.QUEUE_ADD
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import java.util.*


class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    lateinit var edt1: EditText
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var tts: TextToSpeech
    lateinit var btn3: Button
    lateinit var Iz1: ImageView
    lateinit var btn4: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById(R.id.edt1)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        tts = TextToSpeech(applicationContext, this)
        Iz1 = findViewById(R.id.Iz1)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)


        if (checkSelfPermission(CALL_PHONE) != PERMISSION_GRANTED) {
            requestPermissions(arrayOf(CALL_PHONE), 1)

        }

        btn1.setOnClickListener {
            var data = edt1.text.toString()
            tts.speak(data, QUEUE_ADD, null)

        }
        btn2.setOnClickListener {
            var i = Intent(ACTION_IMAGE_CAPTURE)
            startActivityForResult(i, 1)

            btn3.setOnClickListener {
                var num = 6355
                var i = Intent(Intent.ACTION_CALL)

            }
            btn4.setOnClickListener {
                var data = edt1.text.toString()
                var i = Intent(applicationContext, MainActivity3::class.java)
                i.putExtra("milan", data)
                startActivity(i)
            }
        }
        //result
        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            if (requestCode == 1 && resultCode == RESULT_OK) {
                var bm: Bitmap = data!!.extras!!.get("data") as Bitmap
                Iz1.setImageBitmap(bm)

            }
            super.onActivityResult(requestCode, resultCode, data)
        }

        fun onBackPressed() {
            //finishAffinity()

            var alert = AlertDialog.Builder(this)
            alert.setTitle("Are you sure you want to exit?")
            alert.setPositiveButton("YES", { dialogInterface: DialogInterface, i: Int ->
                finishAffinity()

            })

            alert.setNegativeButton("NO", { dialogInterface: DialogInterface, i: Int ->

                dialogInterface.cancel()
            })


            alert.show()

        }
    }

    override fun onInit(Status: Int)
    {
        tts.setLanguage(Locale.ENGLISH)
        tts.setPitch(0.5f)
        tts.setSpeechRate(0.8f)
    }
}








