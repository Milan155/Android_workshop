package com.example.module4part_2

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.view.isVisible

class chekinternet : AppCompatActivity() {
    lateinit var button1:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chekinternet)


        button1=findViewById(R.id.chekbutton)

        button1.setOnClickListener {
            if(chekinternet(this)){
                Toast.makeText(this,"Connected",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Disconnected", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun chekinternet(chekinternet: chekinternet): Boolean {
        val connectivityManager=chekinternet.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
        {
            val network=connectivityManager.activeNetwork?: return false
            val activeNetwork=connectivityManager.getNetworkCapabilities(network)
            return when{
                activeNetwork!!.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork!!.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ->true

                else -> false
            }
        }else{
            val networkInfo= connectivityManager.activeNetworkInfo ?: return false
            return networkInfo.isConnected




            }
        }
    }
