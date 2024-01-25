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

class BlankFragment : Fragment() {
    lateinit var next1: TextView
    lateinit var viewPager: ViewPager
    lateinit var showbutton: Button

    lateinit var textView: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        viewPager = requireActivity().findViewById(R.id.viewpagefragment)
        next1 = view.findViewById(R.id.nextone)
        next1.setOnClickListener {
            viewPager.run { this.setCurrentItem(1) }
        }
        showbutton=view.findViewById(R.id.ansbutton)

        textView=view.findViewById(R.id.ans)

        showbutton.setOnClickListener {
            textView.visibility=view.visibility
        }
        return view
    }

}