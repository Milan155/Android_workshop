package com.example.a5_secondtask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a5_secondtask.databinding.ActivityUpdateBinding

class Update : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateBinding
    lateinit var dbHelper: Dbhelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        dbHelper = Dbhelper(applicationContext)

        var i= intent
        var id = i.getIntExtra("id",101)
        binding.edtname.setText(i.getStringExtra("myname"))
        binding.edtnum.setText(i.getStringExtra("mynumber"))

        binding.btnupdate.setOnClickListener {

            var name = binding.edtname.text.toString()
            var num = binding.edtnum.text.toString()

            var m= Model()
            m.id=id
            m.name=name
            m.num=num

            var id = dbHelper.updatedata(m)
            startActivity(Intent(applicationContext,MainActivity2::class.java))

        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()


    }
}