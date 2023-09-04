package com.example.optionmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.optionmenu.R.menu

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
        when (item.itemId) {
            R.id.a1 -> {
                Toast.makeText(applicationContext, "show call icon", Toast.LENGTH_SHORT).show()

                return true
            }

            R.id.a2 -> {
                Toast.makeText(applicationContext, "show share icon", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.a3 -> {
                Toast.makeText(applicationContext, "show share link", Toast.LENGTH_SHORT).show()
                return true
            }
        }

     }

}