package com.example.a5_fourassigment

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.TextUtils
import android.text.style.UnderlineSpan
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a5_fourassigment.databinding.ActivityLoginRegisterBinding
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class login_register_activity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginRegisterBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var sharedPreferencesUser: SharedPreferences

    lateinit var edtOTP: EditText
    lateinit var imgVerify: ImageView
    lateinit var user_mob1:EditText


    private lateinit var auth: FirebaseAuth
    lateinit var verificationid:String
    lateinit var mcallback: PhoneAuthProvider.OnVerificationStateChangedCallbacks




    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        imgVerify=findViewById(R.id.imgVerify)
        edtOTP = findViewById(R.id.edtOTP)
        user_mob1 = findViewById(R.id.edtPhone)
        auth = FirebaseAuth.getInstance()

        var str="login"
        val span= SpannableString(str)

        span.setSpan(UnderlineSpan(),0,span.length,0)
        binding.userLoginTxt.text=span


        sharedPreferences = getSharedPreferences("SESSION", Context.MODE_PRIVATE)
        sharedPreferencesUser = getSharedPreferences("USER_SESSION", Context.MODE_PRIVATE)


        if (sharedPreferences.getBoolean("SESSION", false) && sharedPreferences.getString("email", "")!!.isEmpty())
        {
            startActivity(Intent(this,Addproject::class.java))
        }
        if (sharedPreferences.getBoolean("SESSION", false) && sharedPreferences.getString("email", "")!!.isEmpty())
        {
            startActivity(Intent(this,Addproject::class.java))
        }

        binding.userLoginTxt.setOnClickListener {
            startActivity(Intent(this,employee_login::class.java))
        }

        imgVerify.setOnClickListener {
            if (TextUtils.isEmpty(binding.edtPhone.text.toString())) {
                Toast.makeText(this@login_register_activity, "Please enter a valid phone number.", Toast.LENGTH_SHORT).show()
            } else {

                var mob = binding.edtPhone.text.toString()
                sendverificationcode(mob)
                edtOTP.visibility =  View.VISIBLE
            }
        }
        binding.btnRegister1.setOnClickListener {
            if (TextUtils.isEmpty(edtOTP.text.toString())) {
                Toast.makeText(this@login_register_activity, "Please enter a valid OTP.", Toast.LENGTH_SHORT).show()
            } else {
                val otp: String = edtOTP.text.toString()
                verifycode(otp)

            }
        }

        mcallback=object :PhoneAuthProvider.OnVerificationStateChangedCallbacks()
        {
            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                var code=p0.smsCode
                if (code!=null)
                {
                    edtOTP.setText(code)
                }
                else
                {
                    Toast.makeText(applicationContext,"error",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                p0.printStackTrace()
                Toast.makeText(applicationContext,"failed" + p0.message,Toast.LENGTH_SHORT).show()

            }

            override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
                verificationid=p0
            }
        }
     }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.option,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.option->
            {
                sharedPreferences.edit().clear().commit()
                finish()
                startActivity(Intent(applicationContext,login_register_activity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        finishAffinity()
        super.onBackPressed()
    }

    private fun verifycode(otp: String) {
        val credential = PhoneAuthProvider.getCredential(verificationid,otp)
        signinwithcredential(credential)
    }

    private fun signinwithcredential(credential: PhoneAuthCredential) {

        auth.signInWithCredential(credential)
            .addOnCompleteListener {
                if (it.isSuccessful)
                {
                    var user_fname = binding.edtFName.text.toString()
                    var user_lname = binding.edtLName.text.toString()
                    var user_dob = binding.edtDob.text.toString()
                    var user_email = binding.edtEmail.text.toString()
                    var user_pass = binding.edtPassword.text.toString()
                    var user_mob= binding.edtPhone.text.toString()

                    if (user_fname.length == 0 && user_lname.length == 0 &&  user_dob.length==0 && user_email.length == 0
                        && user_pass.length == 0  && user_mob.length ==0
                    )
                    {
                        binding.edtFName.setError("Please enter first name")
                        binding.edtLName.setError("Please enter last name")
                        binding.edtEmail.setError("Please enter email")
                        binding.edtDob.setError("Please enter Date of birth")
                        binding.edtPhone.setError("Please enter phone number")
                        binding.edtPassword.setError("Please enter password")
                    }
                    else if (user_fname.length == 0) {
                        binding.edtFName.setError("Please enter first name")
                    } else if (user_lname.length == 0) {
                        binding.edtLName.setError("Please enter last name")
                    } else if (user_email.length == 0) {
                        binding.edtEmail.setError("Please enter email")
                    } else if (user_dob.length == 0) {
                        binding.edtDob.setError("Please enter date of birth")
                    }
                    else if (TextUtils.isEmpty(binding.edtPhone.text.toString())) {
                        binding.edtPhone.setError("Please enter mobile number")
                    } else if (user_pass.length == 0) {
                        binding.edtPassword.setError("Please enter password")
                    }

                    var stringRequest: StringRequest = object : StringRequest(Request.Method.POST,
                        "https://unaffecting-firearm.000webhostapp.com/Employeeregister/emp_register.php",
                        Response.Listener {
                            Toast.makeText(applicationContext, "useradded", Toast.LENGTH_SHORT)
                                .show()
                            binding.edtFName.setText("")
                            binding.edtLName.setText("")
                            binding.edtEmail.setText("")
                            binding.edtDob.setText("")
                            binding.edtPhone.setText("")
                            binding.edtPassword.setText("")

                            var editor: SharedPreferences.Editor = sharedPreferences.edit()
                            editor.putBoolean("SESSION", true)
                            editor.putString("email", user_email)
                            editor.putString("pass", user_pass)
                            editor.commit()
                        },
                        {
                            Toast.makeText(applicationContext," No internet",Toast.LENGTH_SHORT).show()
                        }){
                        override fun getParams(): MutableMap<String, String>? {
                            var map= hashMapOf<String, String>()
                            map["first_name"] = user_fname
                            map["last_name"] = user_lname
                            map["date_of_birth" ] = user_dob
                            map["email"] = user_email
                            map["password"] = user_pass
                            map["phone"] = user_mob

                            return map
                        }

                        }
                    var queue: RequestQueue = Volley.newRequestQueue(this)
                    queue.add(stringRequest)
                    startActivity(Intent(applicationContext,Addproject::class.java))
                    Toast.makeText(applicationContext,"success",Toast.LENGTH_LONG).show()

                }

            }
            .addOnFailureListener {

                Toast.makeText(applicationContext,"error",Toast.LENGTH_LONG).show()
            }

    }
    private fun sendverificationcode(mob: String) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(mob,60, TimeUnit.SECONDS,this,mcallback)
    }
}



