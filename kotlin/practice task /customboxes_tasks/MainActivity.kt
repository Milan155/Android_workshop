package com.example.customtoastanddialog

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {

    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3:Button
    lateinit var btn4:Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1=findViewById(R.id.btn1)
        btn2=findViewById(R.id.btn2)
        btn3=findViewById(R.id.btn3)
        btn3=findViewById(R.id.btn4)


        btn1.setOnClickListener {
            var alertDialog = AlertDialog.Builder(this)
            var layout = LayoutInflater.from(applicationContext)
            var view = layout.inflate(R.layout.customdialog,null)


            var yesbtn1:Button=view.findViewById(R.id.yesbtn)


            yesbtn1.setOnClickListener {

                Toast.makeText(applicationContext,"thanks for coming",Toast.LENGTH_LONG).show()

            }
            alertDialog.setView(view)
            alertDialog.show()
        }
        btn2.setOnClickListener {
            var alertDialog = AlertDialog.Builder(this)
            var layout = LayoutInflater.from(applicationContext)
            var view = layout.inflate(R.layout.locationimage,null)

            var btn1:Button=view.findViewById(R.id.mapbtn1)
            var btn2:Button=view.findViewById(R.id.mapbtn2)

            btn1.setOnClickListener {
                Toast.makeText(applicationContext, "I will do it later", Toast.LENGTH_SHORT).show()
            }

            btn2.setOnClickListener {
                Toast.makeText(applicationContext, "Location is on", Toast.LENGTH_SHORT).show()
            }
            alertDialog.setView(view)
            alertDialog.show()
        }
        btn3.setOnClickListener {
            var alertDialog=AlertDialog.Builder(this)
            var layout = LayoutInflater.from(applicationContext)
            var view = layout.inflate(R.layout.successdesign,null)

            var btn3:Button=view.findViewById(R.id.submitbtn1)

            btn3.setOnClickListener {
                Toast.makeText(applicationContext,"Sumitted successfully",Toast.LENGTH_SHORT).show()
            }
            alertDialog.setView(view)
            alertDialog.show()
        }
        btn4.setOnClickListener {
            var toast=Toast(applicationContext)
            var layout=LayoutInflater.from((applicationContext))
            var view=layout.inflate(R.layout.emojitask,null)

            toast.view=view


        }
    }
}