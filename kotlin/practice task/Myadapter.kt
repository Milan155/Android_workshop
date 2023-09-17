package com.example.grid3

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import java.util.ArrayList

class Myadapter(var context: Context ,var list:MutableList<model>) : BaseAdapter()
{
    override fun getCount(): Int
    {
        return list.size
    }

    override fun getItem(p0: Int): Any
    {
        return list.get(p0)
    }

    override fun getItemId(p0: Int): Long
    {
        return p0.toLong()

    }

    @SuppressLint("MissingInflatedId", "ViewHolder")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View
    {
        var layoutInflater = LayoutInflater.from(context)
        var view = layoutInflater.inflate(R.layout.design, p2, false)

        var image:ImageView = view.findViewById(R.id.photo)
        var text1:TextView= view.findViewById(R.id.txt1)



        image.setImageResource(list.get(p0).image)
        text1.setText(list.get(p0).name)




        return view



    }
}

