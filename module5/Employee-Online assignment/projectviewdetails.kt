package com.example.a5_fourassigment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a5_fourassigment.databinding.ActivityProjectdetailsBinding
import com.example.a5_fourassigment.databinding.ActivityProjectviewdetailsBinding
import org.json.JSONArray

class projectviewdetails : AppCompatActivity() {

    private lateinit var binding: ActivityProjectviewdetailsBinding
    lateinit var list: MutableList<Projectmodel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProjectviewdetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()


        var stringRequest =  StringRequest(Request.Method.GET,"https://unaffecting-firearm.000webhostapp.com/Employeeregister/projectview.php",
            {responce->
                try {
                    var jsonArray = JSONArray(responce)
                    for (i in 0 until jsonArray.length()) {
                        var jsonObject = jsonArray.getJSONObject(i)

                        var id = jsonObject.getInt("id")
                        var pro_name = jsonObject.getString("project_name")
                        var pro_team = jsonObject.getString("project_team_members")
                        var pro_des = jsonObject.getString("project_description")
                        var m = Projectmodel()
                        m.id = id
                        m.project_name = pro_name
                        m.project_team_members = pro_team
                        m.project_description  = pro_des
                        list.add(m)
                    }
                    var adapter = Projectadapter(applicationContext, list)
                    binding.list.adapter = adapter
                }
                catch (e:Exception)
                {
                    e.printStackTrace()
                }
            })
        {
            Toast.makeText(applicationContext, "NO internet", Toast.LENGTH_SHORT).show()
        }

        var queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringRequest)
    }
}
