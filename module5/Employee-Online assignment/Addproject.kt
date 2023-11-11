package com.example.a5_fourassigment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Addproject : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    lateinit var sharedPreferencesUser: SharedPreferences
    lateinit var recycleview:RecyclerView
    lateinit var list: MutableList<Dashboardmodel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addproject)

        sharedPreferences=getSharedPreferences("SESSION",Context.MODE_PRIVATE)
        sharedPreferencesUser=getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        recycleview=findViewById(R.id.recycler)
        list=ArrayList()

        var manager : RecyclerView.LayoutManager =GridLayoutManager(this,2)
        recycleview.layoutManager=manager

        list.add(Dashboardmodel(R.drawable.add,"Add project"))
        list.add(Dashboardmodel(R.drawable.viewthe,"View Project"))

        var myAdapter=Myadapter(applicationContext,list)
        recycleview.adapter=myAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.option->
            {
                sharedPreferences.edit().clear().commit()
                sharedPreferencesUser.edit().clear().commit()
                finish()
                startActivity(Intent(applicationContext,login_register_activity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        finishAffinity()
        super.onBackPressed()
    }
}