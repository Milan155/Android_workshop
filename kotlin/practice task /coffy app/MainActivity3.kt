package com.example.coffy

import android.Manifest.permission.CALL_PHONE
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AlertDialog

class MainActivity3 : AppCompatActivity() {
    lateinit var chk1: CheckBox
    lateinit var chk2: CheckBox
    lateinit var chk3: CheckBox
    lateinit var btn1: Button
    lateinit var btn2: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)


        chk1 = findViewById(R.id.chk1)
        chk2 = findViewById(R.id.chk2)
        chk3 = findViewById(R.id.chk3)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)

        if (checkSelfPermission(CALL_PHONE) != PERMISSION_GRANTED) {
            requestPermissions(arrayOf(CALL_PHONE), 1)


        }


        btn1.setOnClickListener {

            var amount = 0
            var builder = StringBuilder("Selected Items:")


            if (chk1.isChecked) {
                builder.append("\n Pizza @ Rs.100")
                amount += 100
            }
            if (chk2.isChecked) {
                builder.append("\n Burger @ Rs.70")
                amount += 70
            }
            if (chk3.isChecked) {
                builder.append("\n Coffee @ Rs.120")
                amount += 120
            }

            builder.append("\n Total :" + amount)

            btn2.setOnClickListener {
                var num = 9327100525
                var i = Intent(Intent.ACTION_CALL)

            }

            //Toast.makeText(applicationContext,""+builder.toString(),Toast.LENGTH_LONG).show()


            var i = Intent(applicationContext, billMainActivity4::class.java)
            i.putExtra("bill", builder.toString())
            startActivity(i)


        }


    }

    override fun onBackPressed() {
        //finishAffinity()

        var alert = AlertDialog.Builder(this)
        alert.setTitle("Are you sure you want to exit?")
        alert.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->
            finishAffinity()

        })

    }
}


