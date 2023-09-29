package com.example.whatuptoolbars

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView

class callfragment : Fragment() {

    lateinit var list3:ListView
    lateinit var listcall: MutableList<model>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view=inflater.inflate(R.layout.fragment_callfragment, container, false)

        list3=view.findViewById(R.id.callid)
        listcall=ArrayList()

        listcall.add(model(R.drawable.natural1,"milan","9099972756"))
        listcall.add(model(R.drawable.nature2,"milan2","9099972756"))


        var adapter4=adapter4(requireActivity(),listcall)
        list3.adapter=adapter4
        return view
    }
}
