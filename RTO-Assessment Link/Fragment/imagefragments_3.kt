package com.example.rto_assessment.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.rto_assessment.R

class imagefragments_3 : Fragment() {


    lateinit var viewPager: ViewPager
    lateinit var text1: TextView
    lateinit var text3: TextView
    lateinit var image1: ImageView
    lateinit var showbutton1: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_imagefragments_3, container, false)
        viewPager = requireActivity().findViewById(R.id.viewpagefragment2)
        text1=view.findViewById(R.id.text5)
        text3=view.findViewById(R.id.next3)
        image1=view.findViewById(R.id.image3)
        showbutton1=view.findViewById(R.id.showbutton3)

        showbutton1.setOnClickListener {
            text1.visibility=view.visibility
        }

        text3=view.findViewById(R.id.next3)
        text3.setOnClickListener {
            viewPager.run { this.setCurrentItem(1) }
        }



        return view
    }

}