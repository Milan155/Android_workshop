package com.example.a5_lasttaskupload

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a5_lasttaskupload.databinding.ActivityMainBinding
import org.json.JSONException

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        sharedPreferences = getSharedPreferences("SESSION", Context.MODE_PRIVATE)

        if(sharedPreferences.getBoolean("SESSION",false) && !sharedPreferences.getString("name","")!!.isEmpty())
        {
            startActivity(Intent(this,MainActivity3::class.java))
            finish()
        }
        if (sharedPreferences.getBoolean("SESSION", false) && sharedPreferences.getString("name", "")!!.isEmpty())
        {
            startActivity(Intent(this,MainActivity3::class.java))
        }


        binding.loginButton.setOnClickListener {

            var name = binding.login.text.toString()
            var pass = binding.password.text.toString()

            var stringrequest:StringRequest = object:StringRequest(Request.Method.POST,
                "https://unaffecting-firearm.000webhostapp.com/UploadImage/login.php",{
                        response->
                    try
                    {
                        if(response.trim().equals("0"))
                        {
                            Toast.makeText(applicationContext,"Login Fail",Toast.LENGTH_LONG).show()
                        }
                        else
                        {
                            Toast.makeText(applicationContext,"Login Success",Toast.LENGTH_LONG).show()
                            var editor:SharedPreferences.Editor = sharedPreferences.edit()
                            editor.putBoolean("SESSION",true)
                            editor.putString("name",name)
                            editor.putString("password",pass)
                            editor.commit()
                            startActivity(Intent(applicationContext,MainActivity3::class.java))
                        }
                    }

                    catch(e:JSONException)
                    {
                        e.printStackTrace()
                    }

                },
                {
                    Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
                })
            {
                override fun getParams(): MutableMap<String, String>?
                {
                    var map = HashMap<String,String>()
                    map["name"]=name
                    map["password"]=pass
                    return map
                }
            }

            var queue: RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringrequest)

        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}


