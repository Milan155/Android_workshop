package com.example.grid3

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView

class MainActivity : AppCompatActivity() {

    lateinit var gridView: GridView
    lateinit var list: MutableList<model>


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridView = findViewById(R.id.grid1)
        list = ArrayList()

        list.add(model(R.drawable.fafda,"fafda","15","milan"))
        list.add(model(R.drawable.burger,"burger","15","milan"))
        list.add(model(R.drawable.pizza,"pizza","15","milan"))


        var myadapter = Myadapter(applicationContext, list)
        gridView.adapter = myadapter

        gridView.setOnItemClickListener {  parent, view, position, id ->
            var i= Intent(applicationContext,MainActivity2::class.java)
            i.putExtra("pos",position)
            i.putExtra("image",list.get(position).image)
            i.putExtra("name",list.get(position).name)
            i.putExtra("number",list.get(position).number)
            i.putExtra("method",list.get(position).method)
            startActivity(i)





        }

    }

}


