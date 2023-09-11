package com.example.loginscreenslayouts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import com.example.loginscreenslayouts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var nam = binding.edt1.text.toString()
        var pass = binding.edt2.text.toString()

        binding.bt1.setOnClickListener {

            var nam = binding.edt1.text.toString()
            var pass = binding.edt2.text.toString()

            if (nam.length == 0 && pass.length == 0) {
                binding.edt1.setError("please Enter name")
            } else if (nam.length == 0) {
                binding.edt2.setError("Please Enter password")
            } else {
                if (nam == "12000" && pass == "12000") {
                    var i1 = Intent(applicationContext, MainActivity2::class.java)
                    startActivity(i1)
                } else {
                    Toast.makeText(applicationContext, "wrong", Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.chek1.setOnClickListener {
            if (binding.chek1.isChecked) {
                binding.edt2.inputType = 1


            } else {
                binding.edt2.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }
    }


}
