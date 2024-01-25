package com.example.rto_assessment.Activity

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.DialogFragment
import com.example.rto_assessment.R
import com.example.rto_assessment.databinding.ActivityMainBinding
import com.example.rto_assessment.databinding.ActivityRegistrationBinding
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
import java.util.Calendar
import java.util.concurrent.Executors

class Rto_registration : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var binding:ActivityRegistrationBinding
    var city = arrayOf("Rajkot","Ahmedabad","Baroda")
    lateinit var image: ImageView
    lateinit var btnsubmit: Button
    lateinit var imageuri: Uri

    private val contract = registerForActivityResult(ActivityResultContracts.GetContent())
    {
        imageuri = it!!
        image.setImageURI(it)
    }

    companion object{
        lateinit var dOB:EditText
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_dropdown_item,city)
        binding.spin1.adapter=adapter
        binding.spin1.setOnItemSelectedListener(this)

        dOB=findViewById(R.id.DOB)
        dOB.setOnClickListener {
            var d1 = MyDatePicker()
            d1.show(supportFragmentManager, "Select Date")
        }

        image = findViewById(R.id.img)
        image.setOnClickListener {
            contract.launch("image/*")
        }
        btnsubmit = findViewById(R.id.register)
        btnsubmit.setOnClickListener {
            upload()
            Toast.makeText(applicationContext, "Please wait for 10-second", Toast.LENGTH_SHORT).show()
            Handler().postDelayed(Runnable {
                var i= Intent(applicationContext, MainActivity::class.java)
                startActivity(i)
            },10000)
        }

    }
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        Toast.makeText(applicationContext,""+city,Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        Toast.makeText(applicationContext, "Not selected", Toast.LENGTH_SHORT).show()
    }
    class MyDatePicker :DialogFragment(),DatePickerDialog.OnDateSetListener{
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

            var c = Calendar.getInstance()
            var date = c.get(Calendar.DAY_OF_MONTH)
            var month = c.get(Calendar.MONTH)
            var year = c.get(Calendar.YEAR)

            return DatePickerDialog(requireActivity(), this, year, month, date)
        }

        override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
            Rto_registration.dOB.setText(
                StringBuilder()
                    .append(p3).append("/").append(p2 + 1).append("/")
                    .append(p1).append("")
            )
        }
}

    private fun upload()
    {
        val filesDir = applicationContext.filesDir
        val file = File(filesDir,"image.png")
        val inputstream = contentResolver.openInputStream(imageuri)
        val outputstream = FileOutputStream(file)
        inputstream!!.copyTo(outputstream)

        val requestBody = file.asRequestBody("Image/*".toMediaTypeOrNull())
        val image = MultipartBody.Part.createFormData("Image",file.name,requestBody)
        val city: RequestBody = RequestBody.Companion.create(MultipartBody.FORM,binding.spin1.performContextClick().toString())
        val name: RequestBody = RequestBody.Companion.create(MultipartBody.FORM,binding.name.text.toString())
        val mobile : RequestBody = RequestBody.Companion.create(MultipartBody.FORM,binding.mobile.text.toString())
        val email: RequestBody = RequestBody.Companion.create(MultipartBody.FORM,binding.email.text.toString())
        val date: RequestBody = RequestBody.Companion.create(MultipartBody.FORM,binding.date.text.toString())
        val DOB: RequestBody = RequestBody.Companion.create(MultipartBody.FORM,binding.DOB.text.toString())


        val retrofit = Retrofit.Builder()
            .baseUrl("https://unaffecting-firearm.000webhostapp.com/RTO/")
            .addConverterFactory(GsonConverterFactory.create())
            .callbackExecutor(Executors.newSingleThreadExecutor())
            .build()
            .create(UploadService::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val response=retrofit.uploadImage(image,city,name,mobile,email,date,DOB)
            Log.d("Milan12345",response.toString())
        }
    }

}

