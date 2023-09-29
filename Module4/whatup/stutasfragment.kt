package com.example.whatuptoolbars

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import java.util.ArrayList


class stutasfragment : Fragment() {
    lateinit var list2:ListView
    lateinit var liststutas: MutableList<model>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view=inflater.inflate(R.layout.fragment_stutasfragment, container, false)

        list2=view.findViewById(R.id.list2)
        liststutas= ArrayList()

        liststutas.add(model(R.drawable.natural1,"n1","12345"))
        liststutas.add(model(R.drawable.nature2,"n2","12345"))

        var adapter=adapter3(requireActivity(),liststutas)
        list2.adapter=adapter

        return view
    }

}