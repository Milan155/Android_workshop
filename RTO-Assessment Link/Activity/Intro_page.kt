package com.example.rto_assessment.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.rto_assessment.Adapters.questionAdapter
import com.example.rto_assessment.R
import com.example.rto_assessment.databinding.ActivityIntroPageBinding
import com.example.rto_assessment.databinding.ActivityMainBinding

class Intro_page : AppCompatActivity() {

    lateinit var binding:ActivityIntroPageBinding
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroPageBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        viewPager=findViewById(R.id.viewpagefragment)
        val Adapter=questionAdapter(supportFragmentManager)
        viewPager.adapter=Adapter
    }

}