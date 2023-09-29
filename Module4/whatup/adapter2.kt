package com.example.whatuptoolbars

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class adapter2(val context:Context, val itemlist:List<model>):BaseAdapter()
{

    val filteredlist= arrayListOf<model>()

    init {
        filteredlist.addAll(itemlist)
    }
    override fun getCount(): Int {
        return filteredlist.size
    }

    override fun getItem(p0: Int): Any {
        return filteredlist[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = p1?: LayoutInflater.from(context).inflate(R.layout.designfile, p2, false)

        var image:CircleImageView = view.findViewById(R.id.profile_image)
        var txt1:TextView = view.findViewById(R.id.text1name)
        var txt2:TextView = view.findViewById(R.id.txtnum2)


        image.setImageResource(itemlist.get(p0).image)
        txt1.setText(itemlist.get(p0).name)
        txt2.setText(itemlist.get(p0).number)

        val item = filteredlist[p0]
        txt1.text = item.name
        return view




    }
}