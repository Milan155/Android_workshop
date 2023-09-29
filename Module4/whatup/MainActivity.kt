package com.example.whatuptoolbars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {


    lateinit var toolbar: Toolbar
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        toolbar = findViewById(R.id.tool)
        setSupportActionBar(toolbar)

        viewPager = findViewById(R.id.vp)
        setuppager()

        tabLayout = findViewById(R.id.tab)
        tabLayout.setupWithViewPager(viewPager)

    }

    fun setuppager()
    {
        var adapter = adapter(applicationContext,supportFragmentManager)
        adapter.mydata(chatfragment(),"CHAT")
        adapter.mydata(stutasfragment(),"STATUS")
        adapter.mydata(callfragment(),"CALL")

        viewPager.adapter =adapter
    }

}
