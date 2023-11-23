package com.example.a5_lasttaskupload

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.a5_lasttaskupload.databinding.ActivityMain2Binding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.io.FileOutputStream

class MainActivity3 : AppCompatActivity() {


    lateinit var binding: ActivityMain2Binding

    lateinit var image: ImageView
    lateinit var imageuri: Uri
    lateinit var btn:Button

    lateinit var sharedPreferences: SharedPreferences

    private val contract = registerForActivityResult(ActivityResultContracts.GetContent())
    {
        imageuri = it!!
        image.setImageURI(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        image=findViewById(R.id.img)
        image.setOnClickListener { contract.launch("image/*") }
        btn=findViewById(R.id.btn_regi)
        btn.setOnClickListener { upload() }
    }

    private fun upload()
    {
        val filesDir = applicationContext.filesDir
        val file = File(filesDir,"image.png")
        val inputstream = contentResolver.openInputStream(imageuri)
        val outputstream = FileOutputStream(file)
        inputstream!!.copyTo(outputstream)

        val requestBody = file.asRequestBody("image/*".toMediaTypeOrNull())
        val part = MultipartBody.Part.createFormData("img",file.name,requestBody)
        val name1: RequestBody = RequestBody.Companion.create(MultipartBody.FORM,binding.name.text.toString())
        val mobile1:RequestBody = RequestBody.Companion.create(MultipartBody.FORM,binding.mobile.text.toString())
        val email1:RequestBody = RequestBody.Companion.create(MultipartBody.FORM,binding.email.text.toString())
        val pass1:RequestBody = RequestBody.Companion.create(MultipartBody.FORM,binding.pass.text.toString())

        val retrofit = Retrofit.Builder().baseUrl("https://unaffecting-firearm.000webhostapp.com/UploadImage/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UploadService::class.java)

        CoroutineScope(Dispatchers.IO).launch {

            val response = retrofit.uploadImage(part,name1,mobile1,email1,pass1)
            Log.d("Milan12345",response.toString())

        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.logout, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> {
                sharedPreferences.edit().clear().commit()
                finish()
                startActivity(Intent(applicationContext, MainActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        finishAffinity()
        super.onBackPressed()
    }
}

