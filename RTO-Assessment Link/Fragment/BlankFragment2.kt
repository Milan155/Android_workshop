package com.example.rto_assessment.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.rto_assessment.R

class BlankFragment2 : Fragment() {

    lateinit var next1: TextView
    lateinit var viewPager: ViewPager
    lateinit var showbutton2: Button
    lateinit var textView2: TextView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_blank2, container, false)
        viewPager = requireActivity().findViewById(R.id.viewpagefragment)
        next1 = view.findViewById(R.id.nextone)
        next1.setOnClickListener {
            viewPager.run { this.setCurrentItem(1) }
        }
        showbutton2=view.findViewById(R.id.ansbutton2)
        textView2=view.findViewById(R.id.ans2)

        showbutton2.setOnClickListener {
            textView2.visibility=view.visibility
        }
        return view
    }


}