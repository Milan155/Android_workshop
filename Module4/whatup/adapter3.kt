package com.example.whatuptoolbars

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class adapter3 (val context: Context,val itemlist:List<model>):BaseAdapter()
{
val fileteredlist=ArrayList<model>()



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


        var view=p1?:LayoutInflater.from(context).inflate(R.layout.stutasdesgin,p2,false)
        var image:CircleImageView=view.findViewById(R.id.SProfile_Image)
        var text1:TextView=view.findViewById(R.id.Stutasname)
        var text2:TextView=view.findViewById(R.id.Satutasnum)

        image.setImageResource(itemlist.get(p0).image)
        text1.setText(itemlist.get(p0).name)
        return view
    }
}