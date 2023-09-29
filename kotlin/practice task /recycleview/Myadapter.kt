package com.example.recycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Myadapter(var context: Context, var list: ArrayList<model>) :RecyclerView.Adapter<Myadapter.Myview>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myview
    {
        var inflater=LayoutInflater.from(context)
        var view=inflater.inflate(R.layout.design,parent,false)
        return Myview(view)
    }



    override fun onBindViewHolder(holder: Myview, position: Int)
    {
        holder.image.setImageResource(list.get(position).image)
        holder.text.setText(list.get(position).text)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class Myview(itemview:View):RecyclerView.ViewHolder(itemview)

    {
        var image:ImageView=itemview.findViewById(R.id.foodimage1)
        var text:TextView=itemview.findViewById(R.id.fooddetails)


    }

}