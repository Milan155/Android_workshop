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

class imagefragments_4 : Fragment() {

    lateinit var viewPager: ViewPager
    lateinit var text1: TextView
    lateinit var text2:TextView
    lateinit var text3: TextView
    lateinit var image1: ImageView
    lateinit var showbutton1: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_imagefragments_4, container, false)
        viewPager = requireActivity().findViewById(R.id.viewpagefragment2)
        text1=view.findViewById(R.id.text6)
        text2=view.findViewById(R.id.text7)
        text3=view.findViewById(R.id.next4)
        image1=view.findViewById(R.id.image4)
        showbutton1=view.findViewById(R.id.showbutton4)

        showbutton1.setOnClickListener {
            text1.visibility=view.visibility
            text2.visibility=view.visibility
        }

        text3=view.findViewById(R.id.next4)
        text3.setOnClickListener {
            viewPager.run { this.setCurrentItem(1) }
        }



        return view
    }







}
