package com.example.rto_assessment.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.rto_assessment.Fragment.Imagefragments
import com.example.rto_assessment.Fragment.imagefragments_2
import com.example.rto_assessment.Fragment.imagefragments_3
import com.example.rto_assessment.Fragment.imagefragments_4

class rulesAdapter(fm: FragmentManager):FragmentPagerAdapter(fm)

{
    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment {
        when(position)
        {
            0->
            {
                return Imagefragments()
            }
            1->
            {
                return imagefragments_2()
            }
            2->
            {
                return imagefragments_3()
            }
            3->
            {
                return imagefragments_4()
            }
            else->
            {
                return error("error")
            }
        }
    }
}
