package com.example.module4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import android.widget.Toast
import com.example.module4.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() {

    private lateinit var binding: ActivityMain4Binding


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.webopen1.webViewClient= WebViewClient()


        binding.webopen1.loadUrl("https://www.google.com")

        binding.backbutton.setOnClickListener {

            if (binding.webopen1.canGoBack())
                Toast.makeText(applicationContext, "back", Toast.LENGTH_SHORT).show()
                binding.webopen1.goBack()

        }
        binding.forwardbutton.setOnClickListener {

            if(binding.webopen1.canGoForward())
                Toast.makeText(applicationContext, "next", Toast.LENGTH_SHORT).show()
            binding.webopen1.goForward()
        }






    }


}