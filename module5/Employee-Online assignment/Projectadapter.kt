package com.example.a5_fourassigment

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class Projectadapter(var context: Context, var  list: MutableList<Projectmodel>) :BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return list.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var layout = LayoutInflater.from(context)
        var view = layout.inflate(R.layout.projectdetails, p2, false)
        var txt1: TextView = view.findViewById(R.id.txt1)
        var txt2: TextView = view.findViewById(R.id.txt2)
        var txt3: TextView = view.findViewById(R.id.txt3)
        var img1: ImageView = view.findViewById(R.id.edit)
        var img2: ImageView = view.findViewById(R.id.delete)
        txt1.setText(list.get(p0).project_name)
        txt2.setText(list.get(p0).project_team_members)
        txt3.setText(list.get(p0).project_description)

        img1.setOnClickListener {

            var i = Intent(context, Projectupdate::class.java)
            i.putExtra("id", list.get(p0).id)
            i.putExtra("pro_name", list.get(p0).project_name)
            i.putExtra("pro_team", list.get(p0).project_team_members)
            i.putExtra("pro_des", list.get(p0).project_description)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }

        img2.setOnClickListener {
            var alert = AlertDialog.Builder(img2.context)
            alert.setTitle("Are you sure you want to delete?")
            alert.setPositiveButton("YES") { dialogInterface: DialogInterface, i: Int ->

                var stringRequest: StringRequest = object : StringRequest(
                    Request.Method.POST,
                    "https://unaffecting-firearm.000webhostapp.com/Employeeregister/pdelet.php",
                    Response.Listener {

                        Toast.makeText(context, "Product Deleted", Toast.LENGTH_LONG).show()
                        var i = Intent(context, projectviewdetails::class.java)
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        context.startActivity(i)

                    },
                    {
                        Toast.makeText(context, "No Internet", Toast.LENGTH_LONG).show()

                    }) {
                    override fun getParams(): MutableMap<String, String>? {
                        var map = HashMap<String, String>()
                        map["id"] = list.get(p0).id.toString()
                        return map
                    }
                }
                var queue:RequestQueue=Volley.newRequestQueue(context)
                queue.add(stringRequest)

            }

            alert.setNegativeButton("no",{dialoginterface:DialogInterface, i:Int->
                dialoginterface.cancel()
            })
            alert.show()
        }
        return view
    }
}
