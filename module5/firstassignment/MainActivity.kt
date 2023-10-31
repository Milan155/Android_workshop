package com.example.module_5firstassignment

import android.content.DialogInterface
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.module_5firstassignment.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var dbhelper: Dbhelper
     var list:List<Model> = ArrayList()
    var arrayList = ArrayList<HashMap<String,String>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.add.setOnClickListener {
            startActivity(Intent(applicationContext,Adddata::class.java))
        }
        list =ArrayList()
        dbhelper= Dbhelper(applicationContext)

        if (list.isNotEmpty())
        {
            list=dbhelper.view()
        }


        for (i in list)
        {
            var myhm=HashMap<String,String>()
            myhm["task"]=i.task
            myhm["title"]=i.title

            arrayList.add(myhm)
        }
        var from = arrayOf("title","task")
        var to= intArrayOf(R.id.title,R.id.task)

        var myadapter= SimpleAdapter(applicationContext,arrayList,R.layout.design,from,to)
        binding.list.adapter = myadapter

        registerForContextMenu(binding.list)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        var a1=menu!!.add(0,1,0,"Update")
        var a2=menu!!.add(0,2,0,"Delete")
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        var imb : AdapterView.AdapterContextMenuInfo = item.menuInfo as AdapterView.AdapterContextMenuInfo
        var pos = imb.position
        var m = list[pos]

        when(item.itemId)
        {
            1->
            {
                var i= Intent(applicationContext,Updatedata::class.java)
                i.putExtra("ID",m.id)
                i.putExtra("TITLE",m.title)
                i.putExtra("TASK",m.task)
                startActivity(i)
            }
            2->
            {
                var alert=AlertDialog.Builder(this)
                alert.setPositiveButton("yes",{dialogenterface: DialogInterface,i:Int->

                    dbhelper.delete(m.id)
                    startActivity(Intent(applicationContext,MainActivity::class.java))
                })
                alert.setNegativeButton("no", { dialogInterface: DialogInterface, i: Int ->
                    dialogInterface.cancel()
                })
                alert.show()
            }
        }
        return super.onContextItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

}