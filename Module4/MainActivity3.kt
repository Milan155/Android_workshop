package com.example.module4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.module4.databinding.ActivityMain3Binding
import com.example.module4.databinding.ActivityMainBinding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.Resultbtn.setOnClickListener {
            var num1 = Integer.parseInt(binding.num1.text.toString())
            var num2 = Integer.parseInt(binding.num2.text.toString())

            if (binding.rd1.isChecked)
            {
                var r= num1+num2
                binding.txtr1.setText("$r")
            }
            else if(binding.rd2.isChecked)
            {
                var r1 = num1 - num2
                binding.txtr1.setText("$r1")
            }
            else if (binding.rd3.isChecked)
            {
                var r2 = num1*num2
                binding.txtr1.setText("$r2")
            }
            else if (binding.rd4.isChecked)
            {
                var r3 = num1/num2
                binding.txtr1.setText("$r3")

            }



        }

    }
}