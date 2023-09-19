package com.example.toolbaapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView


class MainActivity : AppCompatActivity() {

    private   lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private  lateinit var emptyView:TextView
    private   lateinit var listView: ListView
    lateinit var adapter: ArrayAdapter<*>


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar=findViewById(R.id.toolbar1)
        listView=findViewById(R.id.list1)
        emptyView=findViewById(R.id.emptyview)
        adapter=ArrayAdapter<Any?>(this,android.R.layout.simple_list_item_1,resources.getStringArray(R.array.month_array))
        listView.adapter=adapter
        listView.onItemClickListener= OnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this@MainActivity,adapterView.getItemAtPosition(i).toString(),Toast.LENGTH_SHORT).show()
        }
        listView.emptyView=emptyView
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.menu,menu)
        val search=menu!!.findItem(R.id.search_view)
        val searchView=search.actionView as SearchView
        searchView.queryHint = "search"

        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean
            {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return true
            }

        })

        return super.onCreateOptionsMenu(menu)
    }
}