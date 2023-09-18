package com.example.optionmenu

import android.Manifest.permission.CALL_PHONE
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    lateinit var g1:EditText
    lateinit var g2:EditText
    lateinit var g3:EditText
    lateinit var g4:Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        g1 = findViewById(R.id.j1)
        g2 = findViewById(R.id.j2)
        g3= findViewById(R.id.j3)
        g4= findViewById(R.id.j4)


        if (checkSelfPermission(CALL_PHONE) != PERMISSION_GRANTED) {
            requestPermissions(arrayOf(CALL_PHONE), 1)
        }


            var emails=g1.text.toString()
            var sub=g2.text.toString()
            var data=g3.text.toString()

            g4.setOnClickListener {
                var send= Intent(Intent.ACTION_SEND)
                send.putExtra(Intent.EXTRA_EMAIL,emails)
                send.putExtra(Intent.EXTRA_SUBJECT,sub)
                send.putExtra(Intent.EXTRA_TEXT,data)


            }


        }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.a1 -> {
                var num="9327100525"
                var i=Intent(Intent.ACTION_CALL)
                i.setData(Uri.parse("tel:"+num))
                startActivity(i)

                return true
            }

            R.id.a2 -> {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Insert Subject here")
                val app_url = " https://play.google.com/store/apps/details?id=my.example.javatpoint"
                shareIntent.putExtra(Intent.EXTRA_TEXT, app_url)
                startActivity(Intent.createChooser(shareIntent, "Share via"))


                return true
            }

            R.id.a3 -> {
                var url= "https://www.google.com"
                var i=Intent(Intent.ACTION_VIEW)
                i.setData(Uri.parse(url))
                startActivity(i)

                return true
            }
        }
        return super.onOptionsItemSelected(item)

     }

}