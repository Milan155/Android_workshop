package com.example.musicplayerwithserver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayerwithserver.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    lateinit var list:MutableList<Model>
    lateinit var apiinterface: Apiinterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list=ArrayList()

        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recycler.layoutManager=layoutManager

        apiinterface=  Apiclient.getapiclient().create(Apiinterface::class.java)

        var call: Call<List<Model>> =  apiinterface.music()
        call.enqueue(object: Callback<List<Model>> {
            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {

                Toast.makeText(applicationContext,"a", Toast.LENGTH_LONG).show()

                list = response.body() as MutableList<Model>

                var myAdapter = Adapter(applicationContext,list)
                binding.recycler.adapter=myAdapter
            }

            override fun onFailure(call: Call<List<Model>>, t: Throwable) {
                Toast.makeText(applicationContext,"No Internet", Toast.LENGTH_LONG).show()
            }
        })

    }
}
