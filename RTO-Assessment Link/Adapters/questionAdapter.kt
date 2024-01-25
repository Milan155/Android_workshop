package com.example.rto_assessment.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.rto_assessment.Fragment.BlankFragment
import com.example.rto_assessment.Fragment.BlankFragment2
import com.example.rto_assessment.Fragment.BlankFragment3

class questionAdapter(fm: FragmentManager):FragmentPagerAdapter(fm)

{
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        when(position)
        {
            0->
            {
                return BlankFragment()
            }
            1->
            {
                return BlankFragment2()
            }
            2->
            {
                return BlankFragment3()
            }

            else->
            {
                return error("error")
            }
        }
    }
}
