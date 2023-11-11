package com.example.a5_fourassigment

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
import com.example.a5_fourassigment.databinding.ActivityEmployeeLoginBinding
import org.json.JSONException

class employee_login : AppCompatActivity() {

    private lateinit var binding: ActivityEmployeeLoginBinding
    lateinit var sharedPreferencesuser: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_login)
        binding = ActivityEmployeeLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferencesuser = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)

        if (sharedPreferencesuser.getBoolean(
                "USER_SESSION",
                false
            ) && !sharedPreferencesuser.getString("email", "")!!.isEmpty()
        ) {
            startActivity(Intent(this, Addproject::class.java))
            finish()
        }

        binding.btnLogin.setOnClickListener {

            val email = binding.edtEmail.text.toString()
            val pass = binding.edtPassword.text.toString()


            var stringrequest: StringRequest = object : StringRequest(
                Request.Method.POST,
                "https://unaffecting-firearm.000webhostapp.com/Employeeregister/loginregister.php",
                { response ->
                    try {
                        if (response.trim().equals("0")) {
                            Toast.makeText(applicationContext, "Login Fail", Toast.LENGTH_LONG)
                                .show()
                        } else {
                            Toast.makeText(applicationContext, "Login Success", Toast.LENGTH_LONG)
                                .show()
                            var editor: SharedPreferences.Editor = sharedPreferencesuser.edit()
                            editor.putBoolean("USER_SESSION", true)
                            editor.putString("email", email)
                            editor.putString("pass", pass)
                            editor.commit()
                            startActivity(Intent(applicationContext, Addproject::class.java))
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                },
                {
                    Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_LONG).show()

                })

            {
                override fun getParams(): MutableMap<String, String>? {

                    var map = HashMap<String, String>()
                    map["email"] = email
                    map["password"] = pass

                    return map
                }

            }
            var queuse:RequestQueue = Volley.newRequestQueue(this)
            queuse.add(stringrequest)

        }

    }
    override fun onBackPressed() {
        finishAffinity()
        super.onBackPressed()
    }
    }
