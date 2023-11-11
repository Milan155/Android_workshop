package com.example.a5_fourassigment

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a5_fourassigment.databinding.ActivityProjectupdateBinding

class Projectupdate : AppCompatActivity() {

    private lateinit var binding: ActivityProjectupdateBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProjectupdateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i = intent
        var id = i.getIntExtra("id",101)
        binding.edtProjectName.setText(i.getStringExtra("pro_name"))
        binding.edtMember.setText(i.getStringExtra("pro_team"))
        binding.edtDescription.setText(i.getStringExtra("pro_des"))

        binding.btnUpdateProject.setOnClickListener {

            var pname = binding.edtProjectName.text.toString()
            var pmember = binding.edtMember.text.toString()
            var pdes = binding.edtDescription.text.toString()

            var stringRequest: StringRequest = object : StringRequest(
                com.android.volley.Request.Method.POST,
                "https://unaffecting-firearm.000webhostapp.com/Employeeregister/update.php",
                Response.Listener {

                    Toast.makeText(applicationContext,"Product Updated", Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext,projectviewdetails::class.java))

                },
                {
                    Toast.makeText(applicationContext,"No Internet", Toast.LENGTH_LONG).show()

                })
            {
                override fun getParams(): MutableMap<String, String>?
                {
                    var map = HashMap<String,String>()
                    map["id"]=id.toString()
                    map["project_name"]=pname
                    map["project_team_members"]=pmember
                    map["project_description"]=pdes

                    return map
                }


            }
            var queue: RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringRequest)




        }
    }
}
