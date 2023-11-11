package com.example.a5_fourassigment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a5_fourassigment.databinding.ActivityProjectdetailsBinding

class projectdetails : AppCompatActivity() {

    private lateinit var binding:ActivityProjectdetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProjectdetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.btnAddProject.setOnClickListener {
            var pname= binding.edtProjectName.text.toString()
            var pmem= binding.edtMember.text.toString()
            var pdes= binding.edtDescription.text.toString()


            var stringRequest:StringRequest= object :StringRequest
                (Request.Method.POST,"https://unaffecting-firearm.000webhostapp.com/Employeeregister/insertproject.php",
                        Response.Listener {

                            Toast.makeText(applicationContext, "Project Inserted", Toast.LENGTH_LONG).show()
                            binding.edtProjectName.setText("")
                            binding.edtMember.setText("")
                            binding.edtDescription.setText("")
                            startActivity(Intent(applicationContext,projectviewdetails::class.java))
                        },
                {
                    Toast.makeText(applicationContext,"No Internet", Toast.LENGTH_LONG).show()

                })
            {
                override fun getParams(): MutableMap<String, String>? {

                    var map = HashMap<String, String>()
                    map["project_name"]=pname
                    map["project_team_members"]=pmem
                    map["project_description"]=pdes

                    return map
                }
            }

            var queue:RequestQueue= Volley.newRequestQueue(this)
            queue.add(stringRequest)

        }

    }
}