package com.example.coffy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class secondMainActivity2 : AppCompatActivity() {




    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_main2)

        edt1=findViewById(R.id.Login)
        edt2=findViewById(R.id.pass)
        btn1=findViewById(R.id.Loginbutton)


        btn1.setOnClickListener {
            var name = edt1.text.toString()
            var pass = edt2.text.toString()

            if(name.length==0 && pass.length==0)
            {
                edt1.setError("Please Enter Name")
                edt2.setError("Please Enter Password")
            }
            else if(name.length==0)
            {
                edt1.setError("Please Enter Name")
            }
            else if(pass.length==0)
            {
                edt2.setError("Please Enter Password")
            }
            else
            {
                if(name == "coffy" && pass == "12345") {
                    var i1 = Intent(applicationContext, MainActivity3::class.java)
                    startActivity(i1)
                }
                else{
                    Toast.makeText(applicationContext, "Wrong Details", Toast.LENGTH_SHORT).show()
                }
            }



        }

    }
}