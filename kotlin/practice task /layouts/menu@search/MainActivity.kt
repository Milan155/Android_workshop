package com.example.toolbarvsserchview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Adapter
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.widget.SearchView
import com.example.menuandsearch.R

class MainActivity : AppCompatActivity() {


    lateinit var toolbar: Toolbar
    lateinit var adapter: ArrayAdapter<*>
    lateinit var listView: ListView
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "kotlin app"
        toolbar=findViewById(R.id.toolbar1)
        listView=findViewById(R.id.list1)
        textView=findViewById(R.id.emptyview)
        adapter=ArrayAdapter<Any>(this,android.R.layout.simple_list_item_1,resources.getStringArray(R.array.months_array))
        listView.adapter=adapter
        listView.onItemClickListener=OnItemClickListener{adapterView, view, i, l ->
            Toast.makeText(this@MainActivity,adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show()
        }

        listView.emptyView = listView

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.menu,menu)
        val search= menu!!.findItem(R.id.search_view)
        val searchView=search.actionView as SearchView
        searchView.queryHint = "search"

        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return true
            }

        })

        return super.onCreateOptionsMenu(menu)
    }

}