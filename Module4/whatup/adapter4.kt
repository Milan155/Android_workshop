package com.example.whatuptoolbars

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class adapter4 (val context: Context,var itemlist:List<model>):BaseAdapter()
{
    var fileteredlist=ArrayList<model>()
    init {
        fileteredlist.addAll(itemlist)
    }
    override fun getCount(): Int {
        return fileteredlist.size
    }

    override fun getItem(p0: Int): Any {
        return fileteredlist[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view=p1?:LayoutInflater.from(context).inflate(R.layout.calldesign,p2,false)
        var image:CircleImageView=view.findViewById(R.id.profile_image3)
        var text1:TextView=view.findViewById(R.id.txtcall3)
        var text2:TextView=view.findViewById(R.id.txtnum3)


        image.setImageResource(itemlist.get(p0).image)
        text1.setText(itemlist.get(p0).name)
        text1.setText(itemlist.get(p0).number)
        return view
    }
}