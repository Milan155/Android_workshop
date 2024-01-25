package com.example.rto_assessment.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.rto_assessment.R

class BlankFragment3 : Fragment() {

    lateinit var next1: TextView
    lateinit var viewPager: ViewPager
    lateinit var showbutton3: Button
    lateinit var textView3: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_blank3, container, false)
        viewPager = requireActivity().findViewById(R.id.viewpagefragment)
        next1 = view.findViewById(R.id.nextone)
        next1.setOnClickListener {
            viewPager.run { this.setCurrentItem(1) }
        }
        showbutton3 = view.findViewById(R.id.ansbutton3)
        textView3 = view.findViewById(R.id.ans3)

        showbutton3.setOnClickListener {
            textView3.visibility = view.visibility
        }
        return view
    }
}
