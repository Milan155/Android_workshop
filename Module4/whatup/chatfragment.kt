package com.example.whatuptoolbars

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast

class chatfragment : Fragment() {
    lateinit var list1: ListView
    lateinit var list: MutableList<model>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_chatfragment, container, false)

        list1= view.findViewById(R.id.listid)
        list = ArrayList()

        list.add(model(R.drawable.natural1, "person1", "9099972756"))
        list.add(model(R.drawable.nature2, "person2", "9898086166"))

        var adapter = adapter2(requireActivity(), list)
        list1.adapter = adapter


        list1.setOnItemClickListener { parent, view, position, id ->

            Toast.makeText(requireActivity(), "" + position, Toast.LENGTH_LONG).show()


        }
        return view

    }
}