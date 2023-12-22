package com.example.wifi_on_off

import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var enableButton: Button
    lateinit var disableButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enableButton = findViewById(R.id.on)
        disableButton = findViewById(R.id.off)

        enableButton.setOnClickListener {
            val wifi =
                applicationContext.getSystemService(WIFI_SERVICE) as WifiManager
            wifi.isWifiEnabled = true
        }

        disableButton.setOnClickListener {
            val wifi =
                applicationContext.getSystemService(WIFI_SERVICE) as WifiManager
            wifi.isWifiEnabled = false
        }

    }
}