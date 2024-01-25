package com.example.rto_assessment.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.rto_assessment.Adapters.questionAdapter
import com.example.rto_assessment.Adapters.rulesAdapter
import com.example.rto_assessment.R
import com.example.rto_assessment.databinding.ActivityIntroPageBinding
import com.example.rto_assessment.databinding.ActivityRulesAndVideosBinding

class Rules_and_videos : AppCompatActivity() {

    lateinit var binding: ActivityRulesAndVideosBinding
    lateinit var viewPager1:ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRulesAndVideosBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)


        viewPager1=findViewById(R.id.viewpagefragment2)
        val Adapter= rulesAdapter(supportFragmentManager)
        viewPager1.adapter=Adapter

    }
}